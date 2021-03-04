package com.mojito.note.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mojito.note.pojo.entity.VideoParse;

/**
 * @author liufengqiang
 * @date 2021-01-11 21:57:03
 */
public interface VideoParseService extends IService<VideoParse> {

    /**
     * 新增视频解析
     * @param videoParse
     */
    void add(VideoParse videoParse);
}
