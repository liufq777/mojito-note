package com.mojito.note.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mojito.note.pojo.entity.NoteDo;
import com.mojito.note.pojo.param.NoteParam;

import java.util.List;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-18 09:47
 */
public interface NoteService extends IService<NoteDo> {

    /**
     * 条件查询
     * @param param
     * @return
     */
    List<NoteDo> listByParam(NoteParam param);
}
