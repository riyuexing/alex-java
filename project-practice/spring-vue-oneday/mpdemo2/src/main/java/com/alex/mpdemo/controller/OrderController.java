package com.alex.mpdemo.controller;

import com.alex.mpdemo.entity.Order;
import com.alex.mpdemo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/2/5 9:33
 */
@RestController
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/order/findAll")
    public List<Order> findAll(){
        return orderMapper.selectAllOrderAndUser();
    }
}
