package com.mojito.note.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mojito.common.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-17 22:35
 */
@Data
@TableName("sys_user")
public class UserDo extends BaseEntity {

    /** 手机号 */
    private String mobileNo;
    /** 密码 */
    private String password;
    /** 昵称 */
    private String nickname;
    /** 头像 */
    private String portrait;
    /** 标签 ,分割 */
    private String tags;
    /** 最后一次登录时间 */
    private Date lastLoginAt;
    /** 个性签名 */
    private String signature;
}
