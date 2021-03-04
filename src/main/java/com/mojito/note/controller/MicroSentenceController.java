package com.mojito.note.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mojito.common.BaseHelper;
import com.mojito.common.Response;
import com.mojito.note.helper.RedisHelper;
import com.mojito.note.pojo.dto.MicroSentenceDto;
import com.mojito.note.pojo.entity.MicroSentence;
import com.mojito.note.pojo.request.MicroSentenceRequest;
import com.mojito.note.service.MicroSentenceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * description 微话佳句
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-17 23:01
 */
@Slf4j
@RestController
@RequestMapping("/micro-sentence")
public class MicroSentenceController {

    @Resource
    private MicroSentenceService microSentenceService;
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 新增佳句
     */
    @PostMapping
    public Response save(@RequestAttribute Long loginId, @Valid @RequestBody MicroSentenceRequest request) {
        MicroSentence microSentenceBo = BaseHelper.r2t(request, MicroSentence.class);
        if (CollectionUtils.isNotEmpty(request.getTags())) {
            microSentenceBo.setTags(String.join(",", request.getTags()));
        }
        microSentenceBo.setUserId(loginId);
        microSentenceService.save(microSentenceBo);
        return Response.ok();
    }

    /**
     * 微话列表
     *
     * @param range 查询范围 0.当前用户 1.所有用户
     */
    @GetMapping
    public Response list(@RequestAttribute Long loginId, @RequestParam(defaultValue = "0") Integer range, String tag) {
        List<MicroSentence> microSentences = microSentenceService.list(Wrappers.<MicroSentence>lambdaQuery()
                .eq(MicroSentence::getUserId, loginId)
                .like(StringUtils.isNotBlank(tag), MicroSentence::getTags, tag)
                .orderByDesc(MicroSentence::getUpdatedAt));

        Set<String> tags = new HashSet<>();
        List<String> titles = new ArrayList<>();

        List<MicroSentenceDto.MicroSentence> collect = microSentences.stream().map(o -> {
            if (StringUtils.isNotBlank(o.getTags())) {
                tags.addAll(Arrays.asList(o.getTags().split(",")));
            }
            titles.add((o.getAuthor() == null ? "" : o.getAuthor())
                    + (o.getSource() == null ? "" : "《" + o.getSource() + "》"));

            MicroSentenceDto.MicroSentence dto = BaseHelper.r2t(o, MicroSentenceDto.MicroSentence.class);
            dto.setContent(dto.getContent().replace("\n", "<br>"));
            if (StringUtils.isNotBlank(o.getTags())) {
                dto.setTags(Arrays.asList(o.getTags().split(",")));
            }
            return dto;
        }).collect(Collectors.toList());

        return Response.ok(new MicroSentenceDto(tags, collect, titles));
    }

    /**
     * 点赞
     */
    @PutMapping("/{id}/favour")
    public Response favour(@RequestAttribute Long loginId, @PathVariable Long id) {
        Object value = redisTemplate.opsForHash().get(RedisHelper.MAP_KEY_USER_LIKED, RedisHelper.getFavourKey(loginId, id));
        boolean isFavour = false;
        if (value != null) {
            isFavour = (boolean) value;
        }
        redisTemplate.opsForHash().put(RedisHelper.MAP_KEY_USER_LIKED, RedisHelper.getFavourKey(loginId, id), !isFavour);
        if (!isFavour) {
            redisTemplate.opsForHash().increment(RedisHelper.MAP_USER_LIKED_COUNT, id, 1);
        }
        return Response.ok();
    }

    /**
     * 标签列表
     *
     * @return
     */
    @GetMapping("/tags")
    public Response tags() {
        List<MicroSentence> microSentenceBos = microSentenceService.list();
        Set<String> tags = new HashSet<>();
        microSentenceBos.forEach(o -> {
            if (StringUtils.isNotBlank(o.getTags())) {
                tags.addAll(Arrays.asList(o.getTags().split(",")));
            }
        });
        return Response.ok(tags);
    }

    /**
     * 删除佳句
     */
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Long id) {
        microSentenceService.removeById(id);
        return Response.ok();
    }
}
