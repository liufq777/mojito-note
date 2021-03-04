package com.mojito.note.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mojito.note.pojo.entity.PhotoStory;

import java.util.List;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-01-23 10:50
 */
public interface PhotoStoryService extends IService<PhotoStory> {

    /**
     * 根据userId查询
     * @param userId
     * @return
     */
    List<PhotoStory> listByUserId(Long userId);
}
