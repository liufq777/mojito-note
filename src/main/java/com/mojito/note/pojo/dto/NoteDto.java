package com.mojito.note.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mojito.note.pojo.constant.PermissionEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-22 12:53
 */
@Getter
@Setter
public class NoteDto {

    private Long id;
    /** 笔记名 */
    private String name;
    /** 笔记内容 */
    private String content;
    /** 笔记html */
    private String contentHtml;
    /** 是否置顶 */
    private Boolean isSetTop;
    /** 分类id */
    private Long categoryId;
    /** 分类名 */
    private String categoryName;
    /** 权限 0.公开 1.自己可见 2.匿名发表
     * @see PermissionEnum */
    private Integer permission;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;
    /** 插图 */
    private String picture;

    /** 用户id */
    private Long userId;
    /** 昵称 */
    private String nickname;
    /** 头像 */
    private String portrait;
}
