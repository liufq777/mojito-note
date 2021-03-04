package com.mojito.note.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mojito.common.BaseEntity;
import lombok.Data;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-17 19:38
 */
@Data
@TableName("person_friends")
public class PersonFriends extends BaseEntity {

    /** 用户id */
    private Long userId;
    /** 内容 */
    private String content;
    /** 权限 0.公开 1.自己可见 2.匿名发表 */
    private Integer permission;
    /** 图片 */
    private String image;
}
