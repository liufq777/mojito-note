package com.mojito.note.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mojito.note.mapper.VideoParseMapper;
import com.mojito.note.pojo.entity.VideoParse;
import com.mojito.note.service.VideoParseService;
import org.springframework.stereotype.Service;

/**
 * @author liufengqiang
 * @date 2021-01-11 21:59:21
 */
@Service
public class VideoParseServiceImpl extends ServiceImpl<VideoParseMapper, VideoParse> implements VideoParseService {

    @Override
    public void add(VideoParse videoParse) {
        save(videoParse);
    }
}
