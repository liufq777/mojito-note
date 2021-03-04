package com.mojito.note.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-24 20:10
 */
@Getter
@Setter
public class TodoPlanDto {

    private Long id;
    /** 内容 */
    private String content;
    /** 类型id */
    private Long categoryId;
    /** 笔记分类名 */
    private String categoryName;
    /** 笔记状态：0.未完成 1.完成 */
    private Boolean isFinish;
    /** 是否置顶 */
    private Boolean isSetTop;
    /** 用户id */
    private Long userId;
    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date updatedAt;
}
