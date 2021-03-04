package com.mojito.note.config;

import com.mojito.common.Response;
import com.mojito.common.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description 统一异常处理
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-18 11:42
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response exceptionHandler(Exception e) {
        log.error("操作失败", e);
        return Response.error("操作失败");
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Response exceptionHandler(RuntimeException e) {
        log.error("RuntimeException", e);
        return Response.error("操作失败！");
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseBody
    public Response illegalArgumentException(IllegalArgumentException e) {
        log.error("操作失败", e);
        return Response.error(e.getMessage());
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public Response exceptionHandler(BindException e) {
        log.error("操作失败", e);
        return Response.error(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = CustomException.class)
    public Response exceptionHandler(CustomException e) {
        log.error(e.getMessage(), e);
        return Response.error(e.getErrorCode());
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Response exceptionHandler(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        return Response.error(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
