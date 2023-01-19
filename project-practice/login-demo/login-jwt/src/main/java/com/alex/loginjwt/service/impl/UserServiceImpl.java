package com.alex.loginjwt.service.impl;

import com.alex.loginjwt.context.UserContext;
import com.alex.loginjwt.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/1/19 15:25
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void doSomething() {
        String currentUserName = UserContext.getCurrentUserName();
        System.out.println("Service层---当前用户登录名:"+currentUserName);
    }
}
