package com.mojito.note.pojo.constant;

import lombok.Getter;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-18 16:55
 */
@Getter
public enum ConstsKeyEnum {

    /** 名字常量key */
    KEY_NAME("key_name"),
    /** 形容词常量key */
    KEY_ADJECTIVE("key_adjective"),
    /** 头像URL */
    KEY_PORTRAIT_URL("key_portrait_url"),
    /** 默认头像 */
    KEY_DEFAULT_PORTRAIT("key_default_portrait");

    private String value;

    ConstsKeyEnum(String value) {
        this.value = value;
    }
}
