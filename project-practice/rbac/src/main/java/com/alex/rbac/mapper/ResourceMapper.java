package com.alex.rbac.mapper;

import com.alex.rbac.model.entity.Resource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/1/19 17:20
 */
@Repository
public interface ResourceMapper extends BaseMapper<Resource> {

    /**
     * 根据用户id获取权限id *
     * @param userId
     * @return
     */
    Set<Long> selectIdsByUserId(Long userId);
}
