package com.mojito.note.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mojito.common.BaseEntity;
import lombok.Data;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-01-23 16:08
 */
@Data
@TableName("photo_story")
public class PhotoStory extends BaseEntity {

    /** 用户id */
    private Long userId;
    /** 照片URL */
    private String photoUrl;
    /** 感想 */
    private String impression;
}
