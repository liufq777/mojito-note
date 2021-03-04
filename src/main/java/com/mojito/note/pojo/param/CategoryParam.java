package com.mojito.note.pojo.param;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-08-12 13:43
 */
@Data
@NoArgsConstructor
public class CategoryParam {

    private Long id;
    /** 分类ids */
    private Set<Long> ids;

    /** 用户id */
    private Long userId;
    /** 分类名 */
    private String name;
    /** 模块类型 0.笔记 1.todo */
    private Integer moduleType;

    /** 权限
     * @see PermissionEnum */
    private List<Integer> permissions;

    public CategoryParam(Long id) {
        this.id = id;
    }
}
