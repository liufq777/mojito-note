package com.mojito.note.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mojito.common.BaseHelper;
import com.mojito.common.Response;
import com.mojito.common.annotation.PassToken;
import com.mojito.note.pojo.dto.UserDto;
import com.mojito.note.pojo.entity.UserDo;
import com.mojito.note.pojo.request.LoginRequest;
import com.mojito.note.pojo.request.UserRequest;
import com.mojito.note.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * description 用户系统
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-17 21:39
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户登录：验证码登录和微信登录
     */
    @PassToken
    @CrossOrigin
    @PostMapping("/login")
    public Response login(@RequestBody @Valid LoginRequest request) {
        if ("1234".equals(request.getVerifyCode())) {
            UserDo userDo = userService.getByMobileNo(request.getMobileNo());
            UserDto dto = BaseHelper.r2t(userDo, UserDto.class);
            dto.setAuthorization(JWT.create().withAudience(String.valueOf(userDo.getId())).sign(Algorithm.HMAC256(userDo.getMobileNo())));
            return Response.ok("登录成功", dto);
        } else {
            return Response.error("验证码错误");
        }
    }

    /**
     * 更新用户
     */
    @PutMapping
    public Response update(@RequestAttribute Long loginId, @RequestBody UserRequest request) {
//        UserBo userBo = userService.findById(loginId);
//        Assert.notNull(userBo, "用户不存在");
//        BeanUtils.copyProperties(request, userBo, IgnorePropertiesUtils.getNullPropertyNames(request));
//        userService.save(userBo);
        return Response.ok();
    }

    /**
     * 获取用户信息
     */
    @GetMapping
    public Response details(@RequestParam Long userId) {
//        UserBo userBo = userService.findById(userId);
//        Assert.notNull(userBo, "用户不存在");
//        return Response.ok(BaseHelper.r2t(userBo, UserDto.class));
        return null;
    }
}
