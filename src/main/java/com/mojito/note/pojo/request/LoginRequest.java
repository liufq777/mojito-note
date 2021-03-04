package com.mojito.note.pojo.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

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

    @Pattern(regexp = "^1[0-9]{10}$",message = "手机号格式错误")
    @NotEmpty(message = "手机号不能为空")
    private String mobileNo;
    @NotEmpty(message = "验证码不能为空")
    private String verifyCode;
}
