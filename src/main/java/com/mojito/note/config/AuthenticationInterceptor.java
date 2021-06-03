package com.mojito.note.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.mojito.common.annotation.PassToken;
import com.mojito.common.exception.CustomException;
import com.mojito.note.pojo.entity.UserDo;
import com.mojito.note.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * description token认证处理
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-18 11:15
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws CustomException {
        // 从 http 请求头中取出 token
        String authorization = httpServletRequest.getHeader("Authorization");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        //检查是否有passToken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        } else {
            if (StringUtils.isNotEmpty(authorization)) {
                // 获取 token 中的 user id
                String userId;
                try {
                    userId = JWT.decode(authorization).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("获取token中的user id异常");
                }
                UserDo userBo = userService.getById(Long.parseLong(userId));
                if (userBo == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                //验证token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(userBo.getMobileNo())).build();
                try {
                    jwtVerifier.verify(authorization);
                    httpServletRequest.setAttribute("loginId", userId);
                } catch (JWTVerificationException e) {
                    log.error("验证token异常", e);
//                    throw new CustomException(CODE_ERROR_AUTHORIZATION);
                }
            } else {
//                throw new CustomException(CODE_ERROR_AUTHORIZATION);
            }
        }
        return true;
    }
}
