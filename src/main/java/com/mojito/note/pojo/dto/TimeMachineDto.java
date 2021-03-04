package com.mojito.note.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * @author liufengqiang
 * @date 2020-11-20 17:47:42
 */
@Data
public class TimeMachineDto {

    private Long id;
    /** 内容 */
    private String content;
    /** 图片url */
    private List<String> imageUrls;
    /** 创建时间 */
    private String createdAt;
}
