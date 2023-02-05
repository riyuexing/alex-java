package com.alex.helloworld.controller;

import com.alex.helloworld.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/2/4 16:06
 */
@RestController
public class ParamsController {

    @RequestMapping(value = "/getTest1",method = RequestMethod.GET)
    public String getTest1(){
        return "GET请求";
    }

    @RequestMapping(value = "/getTest2",method = RequestMethod.GET)
    public String getTest2(String nickname, String phone){
        System.out.println("昵称："+nickname);
        System.out.println("手机："+phone);
        return "GET请求";
    }

    // 加了 @RequestParam 后，这个参数必须传递，否则会报400
    @RequestMapping(value = "/getTest3",method = RequestMethod.GET)
    public String getTest3(@RequestParam("nickname") String name, String phone){
        System.out.println("昵称："+name);
        System.out.println("手机："+phone);
        return "GET请求";
    }

    @RequestMapping(value = "/postTest1",method = RequestMethod.POST)
    public String postTest1(){
        return "POST请求";
    }

    @RequestMapping(value = "/postTest2",method = RequestMethod.POST)
    public String postTest2(String username,String password){
        System.out.println("username: "+username);
        System.out.println("password: "+password);
        return "POST请求";
    }

    @RequestMapping(value = "/postTest3",method = RequestMethod.POST)
    public String postTest3(User user){
        System.out.println("username: "+user.getUsername());
        System.out.println("password: "+user.getPassword());
        return "POST请求";
    }

    // 传JSON类型，否则报405错误
    @RequestMapping(value = "/postTest4",method = RequestMethod.POST)
    public String postTest4(@RequestBody User user){
        System.out.println("username: "+user.getUsername());
        System.out.println("password: "+user.getPassword());
        return "POST请求";
    }

    @GetMapping("/test/**")
    public String test(HttpServletRequest request){
        System.out.println(request.getRequestURL());
        return "通配符请求";
    }


}
