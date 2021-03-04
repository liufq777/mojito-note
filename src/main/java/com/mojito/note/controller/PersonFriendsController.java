package com.mojito.note.controller;//package com.mojito.note.comtroller;
//
//import com.mojito.common.Response;
//import com.mojito.note.pojo.request.PersonFriendsRequest;
//import com.mojito.note.service.PersonFriendsService;
//import com.mojito.note.service.UserService;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.validation.Valid;
//
///**
// * description 个人朋友圈
// *
// * @author liufengqiang <liufengqiang@touchealth.com>
// * @date 2019-12-17 19:12
// */
//@RestController
//@RequestMapping("/person-friends")
//public class PersonFriendsController {
//
//    @Resource
//    private PersonFriendsService personFriendsService;
//    @Resource
//    private UserService userService;
////    @Resource
////    private SysCommentService sysCommentService;
//
//    @PostMapping
//    public Response save(@RequestAttribute Long loginId, @Valid @RequestBody PersonFriendsRequest request) {
////        PersonFriendsBo personFriendsBo = BaseHelper.r2t(request, PersonFriendsBo.class);
////        personFriendsBo.setUserId(loginId);
////        personFriendsService.save(personFriendsBo);
//        return Response.ok();
//    }
//
//    @GetMapping("/list")
//    public Response list() {
////        return Response.ok(personFriendsService.listAll().stream().filter(o -> !PermissionEnum.PERMISSION_PRIVATE.getValue().equals(o.getPermission())).map(o -> {
////            PersonFriendsDto dto = BaseHelper.r2t(o, PersonFriendsDto.class);
////            UserBo userBo = userService.findByPermission(o.getPermission(), o.getUserId());
////            dto.setNickname(userBo.getNickname());
////            dto.setPortrait(userBo.getPortrait());
////            List<SysCommentBo> sysCommentBos = sysCommentService.findByModuleId(o.getId());
////            if (!CollectionUtils.isEmpty(sysCommentBos)) {
////                dto.setComments(sysCommentBos.stream().peek(x -> {
////                    UserBo user = userService.findByPermission(x.getPermission(), x.getUserId());
////                    BeanUtils.copyProperties(user, x, IgnorePropertiesUtils.getNullPropertyNames(userBo));
////                }).collect(Collectors.toList()));
////            }
////            return dto;
////        }).collect(Collectors.toList()));
//        return null;
//    }
//
//    @DeleteMapping("/{id}")
//    public Response delete(@RequestAttribute Long loginId, @PathVariable Long id) {
////        PersonFriendsBo personFriendsBo = personFriendsService.findById(id);
////        Assert.notNull(personFriendsBo, "记录不存在");
////        Assert.isTrue(loginId.equals(personFriendsBo.getUserId()), "权限不足");
////        personFriendsBo.setDeletedFlg(loginId);
////        personFriendsBo.setDeletedAt(new Date());
////        personFriendsService.save(personFriendsBo);
//        return Response.ok();
//    }
//}
