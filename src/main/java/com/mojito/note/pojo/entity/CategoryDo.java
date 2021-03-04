package com.mojito.note.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mojito.common.BaseEntity;
import lombok.Data;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-08-12 13:47
 */
@Data
@TableName("category")
public class CategoryDo extends BaseEntity {

    /** 用户id */
    private Long userId;
    /** 模块类型 0.笔记 1.todo */
    private Integer moduleType;
    /** 分类名 */
    private String name;
    /** 权限
     * @see PermissionEnum */
    private Integer permission;
}
