package com.mojito.common;

import com.mojito.common.exception.ErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liufengqiang
 * @date 2020-10-25 09:48:01
 */
@Data
@AllArgsConstructor
public class Response {

    /** 状态码 */
    private int code;
    /** 说明 */
    private String msg;
    /** 数据 */
    private Object data;

    public static Response ok() {
        return new Response(200, "请求成功", null);
    }

    public static Response ok(Object entity) {
        return new Response(200, "请求成功", entity);
    }

    public static Response ok(String message, Object entity) {
        return new Response(200, message, entity);
    }

    public static Response error(String message) {
        return new Response(400, message, null);
    }

    public static Response error(ErrorCodeEnum errorCode) {
        return new Response(errorCode.getCode(), errorCode.getMsg(), null);
    }
}
