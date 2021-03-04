package com.mojito.note.pojo.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author liufengqiang
 * @date 2020-11-19 20:54:03
 */
@Data
public class CategoryRequest {

    /** 分类名 */
    @NotBlank(message = "分类名不能为空")
    private String name;
    /** 模块类型 0.笔记 1.todo */
    @NotNull(message = "模块类型不能为空")
    private Integer moduleType;
}
