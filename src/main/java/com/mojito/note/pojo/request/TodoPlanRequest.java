package com.mojito.note.pojo.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-01-29 15:47
 */
@Getter
@Setter
public class TodoPlanRequest {

    private Long id;
    /** 内容 */
    private String content;
    /** 分类名 */
    private Long categoryId;
    /** 分类名 */
    @NotEmpty(message = "分类名不能为空")
    private String categoryName;
    /** 是否完成 */
    private Boolean isFinish;
    /** 是否置顶 */
    private Boolean isSetTop;
}
