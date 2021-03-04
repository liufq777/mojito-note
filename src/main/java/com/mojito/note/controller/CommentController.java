package com.mojito.note.controller;//package com.mojito.note.comtroller;
//
//import com.mojito.common.Response;
//import com.mojito.note.pojo.entity.SysComment;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.validation.Valid;
//
///**
// * description 评论系统
// *
// * @author liufengqiang <liufengqiang@touchealth.com>
// * @date 2019-12-20 09:27
// */
//@RestController
//@RequestMapping("/comment")
//public class CommentController {
//
//    @Resource
//    private SysCommentService sysCommentService;
//
//    /**
//     * 添加评论
//     */
//    @PostMapping
//    public Response save(@RequestAttribute Long loginId, @Valid @RequestBody SysComment sysCommentBo) {
//        sysCommentBo.setUserId(loginId);
//        sysCommentService.save(sysCommentBo);
//        return Response.ok();
//    }
//}
