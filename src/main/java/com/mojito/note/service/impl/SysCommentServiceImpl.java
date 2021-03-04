package com.mojito.note.service.impl;//package com.mojito.note.service.impl;
//
//import com.mojito.note.pojo.table.SysComment;
//import com.mojito.note.service.SysCommentService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * description
// *
// * @author liufengqiang <liufengqiang@touchealth.com>
// * @date 2019-12-20 09:35
// */
//@Service
//public class SysCommentServiceImpl implements SysCommentService {
//
////    @Resource
////    private SysCommentRepository sysCommentRepository;
//
//    @Override
//    public void save(SysComment sysCommentBo) {
////        if (sysCommentBo.getCreatedAt() == null) {
////            sysCommentBo.setCreatedAt(new Date());
////        }
////        if (sysCommentBo.getDeletedFlg() == null) {
////            sysCommentBo.setDeletedFlg(0L);
////        }
////        sysCommentRepository.save(BaseHelper.r2t(sysCommentBo, SysComment.class));
//    }
//
//    @Override
//    public List<SysComment> findByModuleId(Long id) {
////        return BaseHelper.r2t(sysCommentRepository.findByModuleId(id), SysCommentBo.class);
//        return null;
//    }
//
//    @Override
//    public List<SysComment> findByModuleAndIds(Integer module, List<Long> ids) {
////        return BaseHelper.r2t(sysCommentRepository.findByModuleAndModuleIdInAndDeletedFlgOrderByCreatedAt(module, ids, 0L), SysCommentBo.class);
//        return null;
//    }
//}
