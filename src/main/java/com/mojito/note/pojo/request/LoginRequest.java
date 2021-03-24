package com.mojito.note.pojo.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-04-15 21:34
 */
@Getter
@Setter
public class LoginRequest {

    /** 登录类型 0.账号密码 1.验证码 */
    private Integer loginType = 0;
    @Pattern(regexp = "^1[0-9]{10}$",message = "手机号格式错误")
    @NotBlank(message = "手机号不能为空")
    private String mobileNo;
    /** 验证码/密码 */
    private String verifyCode;
}
