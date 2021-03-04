package com.mojito.note.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * @author liufengqiang
 * @date 2020-11-19 12:22:56
 */
@Data
public class TodoListDto {

    private Long id;
    /** 分类名 */
    private String name;
    /** todo列表 */
    private List<TodoDto> todos;

    @Data
    public static class TodoDto {

        private Long id;
        /** 内容 */
        private String content;
        /** 标题 */
        private String title;
        /** 描述 */
        private String describe;
        /** 是否完成 */
        private Boolean isFinish;
        /** 是否置顶 */
        private Boolean isSetTop;
        /** 权限
         * @see PermissionEnum */
        private Integer permission;
        /** 创建时间 */
        private String createdAt;
    }
}
