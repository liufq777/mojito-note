package com.mojito.note.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mojito.common.BaseEntity;
import lombok.Data;

/**
 * @author liufengqiang
 * @date 2020-11-20 17:37:38
 */
@Data
@TableName("time_machine")
public class TimeMachine extends BaseEntity {

    /** 用户id */
    private Long userId;
    /** 内容 */
    private String content;
    /** 图片url */
    private String imageUrls;
}
