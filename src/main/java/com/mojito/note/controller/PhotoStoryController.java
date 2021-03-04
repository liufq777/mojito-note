package com.mojito.note.controller;

import com.mojito.common.BaseHelper;
import com.mojito.common.Response;
import com.mojito.note.pojo.constant.CommonConsts;
import com.mojito.note.pojo.entity.PhotoStory;
import com.mojito.note.pojo.request.PhotoStoryRequest;
import com.mojito.note.service.PhotoStoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * description 照片墙
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-01-23 10:16
 */
@RestController
@RequestMapping("/photo-story")
public class PhotoStoryController {

    @Resource
    private PhotoStoryService photoStoryService;

    @PostMapping
    public Response save(@RequestAttribute Long loginId, @RequestBody PhotoStoryRequest request) {
        PhotoStory photoStoryBo = BaseHelper.r2t(request, PhotoStory.class);
        photoStoryBo.setUserId(loginId);
        photoStoryService.save(photoStoryBo);
        return Response.ok();
    }

    /**
     * 照片故事列表
     *
     * @param range 查询范围 0.当前用户 1.所有用户
     * @return
     */
    @GetMapping("/list")
    public Response list(@RequestAttribute Long loginId, @RequestParam(defaultValue = "0") Integer range) {
        List<PhotoStory> photoStoryBos;
        switch (range) {
            case CommonConsts.QUERY_RANGE_USER_CURRENT:
                photoStoryBos = photoStoryService.listByUserId(loginId);
                break;
            case CommonConsts.QUERY_RANGE_USER_ALL:
                photoStoryBos = photoStoryService.list();
                break;
            default:
                return Response.error("查询范围错误");
        }
        return Response.ok(photoStoryBos);
    }
}
