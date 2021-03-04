package com.mojito.note.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mojito.note.pojo.entity.SysComment;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-19 22:31
 */
@Getter
@Setter
public class PersonFriendsDto {

    private Long id;
    /** 用户id */
    private Long userId;
    /** 内容 */
    private String content;
    /** 昵称 */
    private String nickname;
    /** 头像 */
    private String portrait;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date createdAt;
    /** 评论列表 */
    private List<SysComment> comments;
    /** 图片 */
    private String image;
}
