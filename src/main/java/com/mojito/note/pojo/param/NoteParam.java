package com.mojito.note.pojo.param;

import com.mojito.note.pojo.constant.PermissionEnum;
import lombok.Data;

import java.util.List;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-07-02 18:12
 */
@Data
public class NoteParam {

    /** 用户id */
    private Long userId;
    /** 分类id */
    private Long categoryId;

    /** 权限
     * @see PermissionEnum */
    private List<Integer> permissions;
    /** 搜索 */
    private String search;
}
