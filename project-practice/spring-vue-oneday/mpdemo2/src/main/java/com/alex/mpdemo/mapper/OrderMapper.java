package com.alex.mpdemo.mapper;

import com.alex.mpdemo.entity.Order;
import com.alex.mpdemo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/2/5 9:36
 */
public interface OrderMapper extends BaseMapper<Order> {

    @Select("select * from `order` where uid = #{uid}")
    List<Order> selectByUid(int uid);

    // 查询所有的订单，同时查询订单的用户
    @Select("select * from `order`")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(column = "uid",property = "user", javaType = User.class,
                one=@One(select = "com.alex.mpdemo.mapper.UserMapper.selectById"))

    })
    List<Order> selectAllOrderAndUser();
}
