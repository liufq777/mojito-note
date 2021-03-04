package com.mojito.note.pojo.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-18 17:17
 */
@Getter
@Setter
public class ConstsLibraryRequest {

    /** 常量库类型
     * @see ConstsKeyEnum */
    @NotBlank(message = "常量库类型不能为空")
    private String constsKey;
    /** 常量值 ,分隔 */
    @NotBlank(message = "常量值不能为空")
    private String value;
}
