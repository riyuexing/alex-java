package com.alex.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/2/4 15:41
 */
@RestController
public class HelloController {

    @Autowired
    private Environment environment;

    // http://localhost:8080/hello
    // http://localhost:8080/hello?name=alex
//    @GetMapping("/hello")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String Hello(String name,String phone){
        return "你好，111世界!"+name+":"+phone;
    }

    @GetMapping("/profile")
    public String profile(){
        String[] activeProfiles = environment.getActiveProfiles();
        System.out.println(activeProfiles.length);
        return "profile";
    }
}
