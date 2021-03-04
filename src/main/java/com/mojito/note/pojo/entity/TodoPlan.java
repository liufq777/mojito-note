package com.mojito.note.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mojito.common.BaseEntity;
import lombok.Data;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-22 20:38
 */
@Data
@TableName("todo_plan")
public class TodoPlan extends BaseEntity {

    /** 内容 */
    private String content;
    /** 类型id */
    private Long categoryId;
    /** 是否完成 */
    private Boolean isFinish;
    /** 是否置顶 */
    private Boolean isSetTop;
    /** 权限
     * @see PermissionEnum */
    private Integer permission;
    /** 用户id */
    private Long userId;
}
