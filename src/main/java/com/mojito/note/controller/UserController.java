package com.mojito.note.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mojito.common.BaseHelper;
import com.mojito.common.Response;
import com.mojito.common.annotation.PassToken;
import com.mojito.note.pojo.dto.UserDto;
import com.mojito.note.pojo.entity.UserDo;
import com.mojito.note.pojo.request.LoginRequest;
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
        UserDo user;
        if (Integer.valueOf(0).equals(request.getLoginType())) {
            user = userService.getOne(new QueryWrapper<UserDo>().lambda()
                    .eq(UserDo::getMobileNo, request.getMobileNo())
                    .eq(UserDo::getPassword, request.getVerifyCode()));
        } else {
            if ("1781".equals(request.getVerifyCode())) {
                user = userService.getByMobileNo(request.getMobileNo());
            } else {
                return Response.error("验证码错误");
            }
        }

        UserDto dto = BaseHelper.r2t(user, UserDto.class);
        dto.setAuthorization(JWT.create().withAudience(String.valueOf(user.getId())).sign(Algorithm.HMAC256(user.getMobileNo())));
        return Response.ok("登录成功", dto);
    }
}
