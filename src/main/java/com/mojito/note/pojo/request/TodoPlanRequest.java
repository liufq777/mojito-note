package com.mojito.note.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author liufengqiang
 * @date 2021-06-02 14:23:37
 */
@Data
public class TodoPlanRequest {

    private Long id;
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;
    /**
     * 分类
     */
    @NotBlank(message = "分类不能为空")
    private String category;
    /**
     * 描述
     */
    private String description;
    /**
     * 计划项
     */
    private String todoPlanItem;
}
