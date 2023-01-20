package com.alex.rbac.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/1/19 17:05
 */
@Data
@TableName("resource")
public class Resource {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 路径 *
     */
    private String path;
    /**
     * 名称 *
     */
    private String name;
    /**
     * 类型：0为菜单，1为接口 *
     */
    private Integer type;
}
