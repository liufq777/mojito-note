package com.mojito.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liufengqiang
 * @date 2020-10-25 10:30:09
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    /** 服务器通用错误 */
    CODE_ERROR_SERVER(400, "系统异常"),
    /** 鉴权失败 */
    CODE_ERROR_AUTHORIZATION(401, "鉴权失败");

    /** 错误码 */
    private int code;
    /** 错误信息 */
    private String msg;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
