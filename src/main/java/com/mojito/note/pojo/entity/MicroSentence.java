package com.mojito.note.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mojito.common.BaseEntity;
import lombok.Data;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-17 23:07
 */
@Data
@TableName("micro_sentence")
public class MicroSentence extends BaseEntity {

    /** 用户id */
    private Long userId;
    /** 标签 */
    private String tags;
    /** 来源 */
    private String source;
    /** 作者 */
    private String author;
    /** 内容 */
    private String content;
    /** 背景图地址 */
    private String imageUrl;
}
