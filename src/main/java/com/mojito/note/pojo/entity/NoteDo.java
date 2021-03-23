package com.mojito.note.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mojito.common.BaseEntity;
import lombok.Data;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-22 12:45
 */
@Data
@TableName("note")
public class NoteDo extends BaseEntity {

    /** 用户id */
    private Long userId;
    /** 笔记名 */
    private String name;
    /** 笔记内容 */
    private String content;
    /** 是否置顶 */
    private Boolean isSetTop;
    /** 分类id */
    private Long categoryId;
    /** 笔记分类 */
    private String category;
    /** 权限 0.公开 1.自己可见 2.匿名发表
     * @see PermissionEnum */
    private Integer permission;
    /** 插图 */
    private String picture;
    /** 是否分类 */
    private Boolean isCategory;
    /** 笔记类型 0.开发 1.生活 2.杂文 */
    private Integer noteType;
}
