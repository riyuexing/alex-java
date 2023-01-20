package com.alex.rbac.service.impl;

import com.alex.rbac.mapper.ResourceMapper;
import com.alex.rbac.model.entity.Resource;
import com.alex.rbac.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/1/19 17:09
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {
    @Override
    public Set<Long> getIdsByUserId(Long userId) {
        return baseMapper.selectIdsByUserId(userId);
    }
}
