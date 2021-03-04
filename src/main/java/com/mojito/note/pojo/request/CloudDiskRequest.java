package com.mojito.note.pojo.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author liufengqiang
 * @date 2020-11-29 14:18:54
 */
@Data
public class CloudDiskRequest {

    /** 父id */
    private Long parentId;
    /** 是否是文件夹 */
    @NotNull
    private Boolean isFolder;
    /** 文件名 */
    @NotBlank
    private String fileName;
    /** 文件地址 */
    private String fileUrl;
}
