package com.alex.rbac.controller;

import com.alex.rbac.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/1/19 17:15
 */
@Controller
public class ViewController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/")
    public String index(HttpServletRequest request){
        // 菜单名映射字典,key为uri路径,value为菜单名,方便视图根据uri路径渲染菜单名
        Map<String,String> menuMap = new HashMap<>();
        menuMap.put("/user/account", "用户管理");
        menuMap.put("/user/role", "权限管理");
        menuMap.put("/data", "数据管理");
        request.setAttribute("menuMap", menuMap);

        // 获取当前用户的所有页面权限，并将数据放到request对象中，好让视图渲染
        Set<Long> menus = resourceService.getIdsByUserId(1L);
        request.setAttribute("menus",menus);
        return "index";
    }
}
