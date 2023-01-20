package com.alex.rbac.service;

import com.alex.rbac.model.entity.Resource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/1/19 17:08
 */
public interface ResourceService extends IService<Resource> {
    /**
     * 根据用户id获取该用户的所有权限id *
     * @param userId 用户id
     * @return 权限id集合
     */
    Set<Long> getIdsByUserId(Long userId);
}
