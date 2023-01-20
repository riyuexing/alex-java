package com.alex.rbac.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/1/19 17:47
 */
@Configuration
@MapperScan("com.alex.rbac.mapper")
public class MybatisPlusConfig {
}
