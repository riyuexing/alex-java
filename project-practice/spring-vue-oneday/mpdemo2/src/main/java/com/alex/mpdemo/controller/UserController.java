package com.alex.mpdemo.controller;

import com.alex.mpdemo.entity.User;
import com.alex.mpdemo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // 一对多查询
    @GetMapping("/user/findAll")
    public List<User> find(){
        return userMapper.selectAllUserAndOrders();
    }

    // 条件查询
    @GetMapping("/user/find")
    public List<User> findByCond(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username","张三");
        return userMapper.selectList(queryWrapper);
    }

    // 分页查询
    @GetMapping("/user/findByPage")
    public IPage findByPage(){
        // 设置起始值及每页条数
        Page<User> page = new Page<>(0,2);
        IPage iPage = userMapper.selectPage(page,null);
        return iPage;
    }

}
