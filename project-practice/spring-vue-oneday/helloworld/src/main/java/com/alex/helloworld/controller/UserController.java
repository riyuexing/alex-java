package com.alex.helloworld.controller;

import com.alex.helloworld.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/2/4 17:47
 */
@RestController
public class UserController {

    @ApiOperation("获取用户")
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id){
        System.out.println("用户id:"+id);
        return "根据ID获取用户信息";
    }

    @PostMapping("/user")
    public String save(User user){
        return "添加用户"+user.getUsername();
    }

    @PutMapping("/user")
    public String update(User user){
        return "更新用户信息"+user.getUsername();
    }

    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable int id){
        return "删除用户，id为："+id;
    }
}
