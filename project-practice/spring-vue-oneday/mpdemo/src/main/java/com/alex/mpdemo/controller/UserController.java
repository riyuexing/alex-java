package com.alex.mpdemo.controller;

import com.alex.mpdemo.entity.User;
import com.alex.mpdemo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/2/4 18:32
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List<User> query(){
//        List<User> userList =  userMapper.findAll();
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
        return userList;
    }

    @GetMapping("/user/{id}")
    public User queryById(@PathVariable int id){
//        User user = userMapper.findById(id);
        User user = userMapper.selectById(id);
        return user;
    }

    @PostMapping("/user")
    public String save(@RequestBody User user){
//        int i = userMapper.add(user);
        int i = userMapper.insert(user);
        if(i>0){
            return "插入成功";
        }else{
            return "插入失败";
        }

    }

    // delete localhost:8080/user?id=4
    @DeleteMapping("/user")
    public String deleteByUserId(@RequestBody int id){
        int i = userMapper.deleteById(id);
        if(i>0){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

    @PutMapping("/user")
    public String update(@RequestBody User user){
//        int i = userMapper.update(user);
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",user.getId());
        int i = userMapper.update(user,updateWrapper);
        if(i>0){
            return "更新成功";
        }else{
            return "更新失败";
        }
    }
}
