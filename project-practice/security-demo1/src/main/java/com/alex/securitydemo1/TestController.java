package com.alex.securitydemo1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/1/26 15:24
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "Test...";
    }
}
