package com.mojito.note.pojo.dto;

import lombok.Data;

/**
 * @author liufengqiang
 * @date 2020-12-10 18:41:46
 */
@Data
public class CloudDiskDto {

    private Long id;
    /** 是否是文件夹 */
    private Boolean isFolder;
    /** 文件名 */
    private String fileName;
    /** 文件地址 */
    private String fileUrl;
    /** 创建时间 */
    private String createdAt;
}
