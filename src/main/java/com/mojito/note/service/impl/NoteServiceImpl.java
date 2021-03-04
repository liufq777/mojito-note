package com.mojito.note.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mojito.note.mapper.NoteMapper;
import com.mojito.note.pojo.entity.NoteDo;
import com.mojito.note.pojo.param.NoteParam;
import com.mojito.note.service.NoteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-18 09:47
 */
@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, NoteDo> implements NoteService {

    @Override
    public List<NoteDo> listByParam(NoteParam param) {
        return list(Wrappers.<NoteDo>lambdaQuery()
                .eq(NoteDo::getUserId, param.getUserId())
                .in(!CollectionUtils.isEmpty(param.getPermissions()), NoteDo::getPermission, param.getPermissions())
                .like(StringUtils.isNotBlank(param.getSearch()), NoteDo::getName, param.getSearch())
                .or().like(StringUtils.isNotBlank(param.getSearch()), NoteDo::getContent, param.getSearch())
                .orderByDesc(NoteDo::getIsSetTop)
                .orderByDesc(NoteDo::getUpdatedAt)
        );
    }
}
