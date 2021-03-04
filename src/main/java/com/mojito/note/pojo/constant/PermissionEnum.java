package com.mojito.note.pojo.constant;

import lombok.Getter;

/**
 * description 笔记权限
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-18 21:46
 */
@Getter
public enum PermissionEnum {

    /** 公开 */
    PUBLIC(0),
    /** 匿名 */
    ANONYMITY(1),
    /** 私有 */
    PRIVATE(2);

    private Integer value;

    PermissionEnum(Integer value) {
        this.value = value;
    }
}
