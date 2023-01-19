package com.alex.loginsession.filter;

import com.alex.loginsession.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/1/19 14:11
 */
@Component
public class LoginFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 简单的白名单,登录这个接口直接放行
        if("/login".equals(request.getRequestURI())){
            filterChain.doFilter(request,response);
            return;
        }

        // 已登录就放行
        User user = (User) request.getSession().getAttribute("user");
        if(user != null){
            filterChain.doFilter(request,response);
            return;
        }

        // 走到这里就代表是其他接口，且没有登录
        // 设置响应数据类型为json
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 设置响应内容，请求结束
        out.write("请先登录");
        out.flush();
        out.close();
    }
}
