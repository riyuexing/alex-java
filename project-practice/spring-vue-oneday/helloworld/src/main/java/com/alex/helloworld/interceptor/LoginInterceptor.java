package com.alex.helloworld.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/2/4 17:39
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler){
        System.out.println("LoginInterceptor");
        return true;
    }
}
