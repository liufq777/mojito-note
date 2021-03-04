package com.mojito.note.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mojito.common.BaseEntity;
import com.mojito.note.pojo.constant.PermissionEnum;
import lombok.Data;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-20 09:39
 */
@Data
@TableName("sys_comment")
public class SysComment extends BaseEntity {

    /** 用户id */
    private Long userId;
    /** 模块标识 0.笔记 1.朋友圈 */
    private Integer module;
    /** 模块id */
    private Long moduleId;
    /** 内容 */
    private String content;
    /** 权限
     * @see PermissionEnum */
    private Integer permission = PermissionEnum.PUBLIC.getValue();
}
