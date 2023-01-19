package com.alex.loginjwt.interceptor;

import com.alex.loginjwt.context.UserContext;
import com.alex.loginjwt.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/1/19 15:12
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        // 简单的白名单
        if("/login".equals(request.getRequestURI())){
            return true;
        }

        // 从请求头中获取token字符串并解析
        Claims claims = JwtUtil.parse(request.getHeader("Authorization"));
        // 已登录就直接放行
        if(claims!=null){
            // 将我们之前放到 token 中的 username 存放到上下文对象中
            UserContext.add(claims.getSubject());
            return true;
        }

        // 走到这里就代表其他接口，且没有登录
        // 设置响应数据类型为json
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 设置响应内容，结束请求
        out.write("请先登录");
        out.flush();
        out.close();
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.remove();
        super.afterCompletion(request,response,handler,ex);
    }
}
