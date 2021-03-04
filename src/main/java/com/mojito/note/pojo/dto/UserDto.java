package com.mojito.note.pojo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-04-15 21:37
 */
@Getter
@Setter
public class UserDto {

    private Long id;
    /** 手机号 */
    private String mobileNo;
    /** 昵称 */
    private String nickname;
    /** 头像 */
    private String portrait;
    /** 标签 逗号分割 */
    private String tags;
    /** token */
    private String authorization;
    /** 个性签名 */
    private String signature;
}
