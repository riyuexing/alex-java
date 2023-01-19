package com.alex.loginsession.context;

import com.alex.loginsession.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/1/19 14:27
 */
public final class RequestContext {
    private RequestContext(){}

    public static HttpServletRequest getCurrentRequest(){
        // 获取当前request请求对象
        return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
    }

    public static User getCurrentUser(){
        // 通过request对象获取session对象，再获取当前用户对象
        return (User) getCurrentRequest().getSession().getAttribute("user");
    }
}
