package com.mojito.note.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mojito.common.BaseEntity;
import lombok.Data;

/**
 * @author liufengqiang
 * @date 2021-01-11 22:00:01
 */
@Data
@TableName("video_parse")
public class VideoParse extends BaseEntity {

    /** 视频URL */
    private String videoUrl;
    /** 保存路径 */
    private String filePath;
    /** 视频名 */
    private String videoName;
    /** 解析状态 0.解析中 1.解析成功 2.解析失败 */
    private Integer parseStatus;
}
