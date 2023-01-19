package com.alex.loginjwt.controller;

import com.alex.loginjwt.entity.User;
import com.alex.loginjwt.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/1/19 14:50
 */
@RestController
public class JwtController {

    @PostMapping("/login")
    public String login(@RequestBody User user){
        // 判断账号密码是否正确
        if("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())){
            // 如果正确的话，就返回token
            return JwtUtil.generate(user.getUsername());
        }
        return "账号或密码错误";
    }

    @GetMapping("/api")
    public String api(HttpServletRequest request){
        // 从请求头中获取token
        String jwt = request.getHeader("Authorization");
        // 解析失败就提示用户登录
        if(JwtUtil.parse(jwt) == null){
            return "请先登录";
        }
        // 解析成功就执行业务逻辑返回数据
        return "api成功返回数据";
    }

    @GetMapping("/api2")
    public String api2(){
        return "api2成功返回数据";
    }
}
