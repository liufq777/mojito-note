package com.mojito.note.config;//package com.mojito.note.config;
//
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//
///**
// * description 日志切面处理
// *
// * @author liufengqiang <liufengqiang@touchealth.com>
// * @date 2019-12-18 10:39
// */
//@Aspect
//@Component
//@Slf4j
//public class LogAspect {
//
//    @Pointcut("execution(* com.mojito.note.controller.*.*(..))")
//    public void log() {
//    }
//
//    @Before("log()")
//    public void before(JoinPoint joinPoint) {
////        Object[] args = joinPoint.getArgs();
////        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
////        Method method = signature.getMethod();
////        log.info("接口: {}, 请求参数 ==> {}", method.getName(), JSON.toJSONString(args));
//    }
//
//    @AfterReturning(pointcut = "log()", returning = "result")
//    public void after(JoinPoint joinPoint, Object result) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        log.info("接口: {}, 返回结果 ==> {}", method.getName(), JSON.toJSON(result));
//    }
//}
