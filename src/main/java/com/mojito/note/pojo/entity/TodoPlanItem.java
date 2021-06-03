package com.mojito.note.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mojito.common.BaseEntity;
import lombok.Data;

/**
 * @author liufengqiang
 * @date 2021-06-02 11:29:50
 */
@Data
@TableName("todo_plan_item")
public class TodoPlanItem extends BaseEntity {

    /**
     * 计划id
     */
    private Long todoPlanId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 内容
     */
    private String content;
    /**
     * 是否完成
     */
    private Boolean isComplete;
}
