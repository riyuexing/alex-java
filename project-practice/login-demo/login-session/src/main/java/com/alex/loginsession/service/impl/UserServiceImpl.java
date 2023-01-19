package com.alex.loginsession.service.impl;

import com.alex.loginsession.context.RequestContext;
import com.alex.loginsession.entity.User;
import com.alex.loginsession.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/1/19 14:32
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void doSomething() {
        User user = RequestContext.getCurrentUser();
        System.out.println("service层---当前登录用户对象："+user);
    }
}
