package com.mojito.note.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.mojito.common.BaseHelper;
import com.mojito.common.Response;
import com.mojito.common.util.DateUtils;
import com.mojito.note.pojo.dto.TimeMachineDto;
import com.mojito.note.pojo.entity.TimeMachine;
import com.mojito.note.pojo.request.TimeMachineRequest;
import com.mojito.note.service.TimeMachineService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liufengqiang
 * @date 2020-11-20 17:35:07
 */
@RestController
@RequestMapping("/time-machine")
public class TimeMachineController {

    @Resource
    private TimeMachineService timeMachineService;

    /**
     * 新增
     */
    @PostMapping
    public Response save(@RequestAttribute Long loginId, @RequestBody @Valid TimeMachineRequest request) {
        TimeMachine timeMachine = new TimeMachine();
        timeMachine.setUserId(loginId);
        timeMachine.setContent(request.getContent());
        if (CollectionUtils.isNotEmpty(request.getImageUrls())) {
            timeMachine.setImageUrls(String.join(",", request.getImageUrls()));
        }
        timeMachineService.save(timeMachine);
        return Response.ok();
    }

    /**
     * 列表
     */
    @GetMapping
    public Response list() {
        List<TimeMachineDto> dtos = timeMachineService.list(new QueryWrapper<TimeMachine>().lambda().orderByDesc(TimeMachine::getCreatedAt)).stream().map(o -> {
            TimeMachineDto timeMachineDto = BaseHelper.r2t(o, TimeMachineDto.class);
            if (StringUtils.isNotBlank(o.getImageUrls())) {
                timeMachineDto.setImageUrls(Arrays.asList(o.getImageUrls().split(",")));
            }
            timeMachineDto.setCreatedAt(DateUtils.formatPretty(o.getCreatedAt()));
            return timeMachineDto;
        }).collect(Collectors.toList());
        return Response.ok(dtos);
    }

    /**
     * 删除
     */
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Long id) {
        timeMachineService.removeById(id);
        return Response.ok();
    }
}
