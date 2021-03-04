package com.mojito.note.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-18 17:24
 */
@Data
@TableName("consts_library")
public class ConstsLibrary {

    /** 常量库类型
     * @see ConstsKeyEnum */
    private String constsKey;
    /** 常量值 */
    private String value;
    /** 备注 */
    private String remark;
}
