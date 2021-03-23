package com.mojito.common.exception;

import lombok.Getter;

/**
 * @author liufengqiang
 * @date 2020-10-25 10:29:40
 */
@Getter
public class CustomException extends Exception {

    private ErrorCodeEnum errorCode;

    public CustomException(ErrorCodeEnum errorCode) {
        this.errorCode = errorCode;
    }

    public CustomException(String msg) {
        this.errorCode = ErrorCodeEnum.CODE_ERROR_SERVER;
        this.errorCode.setMsg(msg);
    }

    @Override
    public String getMessage() {
        return errorCode.getCode() + ", " + errorCode.getMsg();
    }
}
