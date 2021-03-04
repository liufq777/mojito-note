package com.mojito.note.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mojito.common.BaseEntity;
import lombok.Data;

/**
 * @author liufengqiang
 * @date 2020-12-10 18:38:25
 */
@Data
@TableName("cloud_disk")
public class CloudDiskDo extends BaseEntity {

    /** 父id */
    private Long parentId;
    /** 是否是文件夹 */
    private Boolean isFolder;
    /** 文件名 */
    private String fileName;
    /** 文件地址 */
    private String fileUrl;
}
