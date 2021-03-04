package com.mojito.note.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mojito.note.mapper.PhotoStoryMapper;
import com.mojito.note.pojo.entity.PhotoStory;
import com.mojito.note.service.PhotoStoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-01-23 10:51
 */
@Service
public class PhotoStoryServiceImpl extends ServiceImpl<PhotoStoryMapper, PhotoStory> implements PhotoStoryService {

    @Override
    public List<PhotoStory> listByUserId(Long userId) {
        return list(new QueryWrapper<PhotoStory>().lambda().eq(PhotoStory::getUserId, userId).orderByDesc(PhotoStory::getCreatedAt));
    }
}
