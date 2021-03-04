package com.mojito.note.pojo.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-07-28 10:52
 */
@Data
public class NoteRequest {

    private Long id;
    /** 标题 */
    @NotBlank(message = "标题不能为空")
    private String name;
    /** 内容 */
    @NotBlank(message = "内容不能为空")
    private String content;
    /** 是否置顶 */
    private Boolean isSetTop;
    /** 分类id */
    private Long categoryId;
    /** 分类名 */
    private String categoryName;
    /** 权限 0.公开 1.自己可见 2.匿名发表
     * @see PermissionEnum */
    private Integer permission;
//    /** 创建时间 */
//    private LocalDateTime createdAt;
    /** 插图 */
    private String picture;
    /** 是否分类 */
    private Boolean isCategory;
}
