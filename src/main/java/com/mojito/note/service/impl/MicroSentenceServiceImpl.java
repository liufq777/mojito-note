package com.mojito.note.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mojito.common.BaseHelper;
import com.mojito.note.mapper.CloudDiskMapper;
import com.mojito.note.mapper.MicroSentenceMapper;
import com.mojito.note.pojo.entity.CloudDiskDo;
import com.mojito.note.pojo.entity.MicroSentence;
import com.mojito.note.service.CloudDiskService;
import com.mojito.note.service.MicroSentenceService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-17 23:06
 */
@Service
public class MicroSentenceServiceImpl extends ServiceImpl<MicroSentenceMapper, MicroSentence> implements MicroSentenceService {

//    @Override
//    public void add(MicroSentence microSentenceBo) {
//        if (microSentenceBo.getCreatedAt() == null) {
//            microSentenceBo.setCreatedAt(new Date());
//        }
//        if (microSentenceBo.getDeletedFlg() == null) {
//            microSentenceBo.setDeletedFlg(0L);
//        }
//        save(BaseHelper.r2t(microSentenceBo, MicroSentence.class));
//    }
//
//    @Override
//    public List<MicroSentence> findByUserId(Long userId) {
//        return list(new QueryWrapper<MicroSentence>().lambda().ge(MicroSentence::getUserId, userId).orderByDesc(MicroSentence::getCreatedAt));
//    }
//
//    @Override
//    public List<MicroSentence> findAll() {
//        return list();
//    }
//
//    @Override
//    public List<MicroSentence> findByIdIn(List<Long> microSentenceIds) {
//        return list(new QueryWrapper<MicroSentence>().lambda().in(MicroSentence::getId, microSentenceIds).orderByDesc(MicroSentence::getCreatedAt));
//    }
}
