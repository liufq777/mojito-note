package com.mojito.common;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liufengqiang
 * @date 2020-10-25 10:18:19
 */
@Data
public class BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /** 创建时间 */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;
    /** 更新时间 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;
    /** 删除状态 */
    @TableLogic
    @TableField(select = false)
    private Long deletedFlg;
    /** 删除时间 */
    private LocalDateTime deletedAt;
}
