package com.alex.mpdemo.mapper;

import com.alex.mpdemo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/2/4 22:22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where id=#{id}")
    User selectById(int id);

    // 查询用户及其所有的订单
    @Select("select * from user")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "mail", property = "mail"),
            @Result(column = "id",property = "orders",javaType = List.class,
                many = @Many(select = "com.alex.mpdemo.mapper.OrderMapper.selectByUid")
            )

    })
    List<User> selectAllUserAndOrders();
}
