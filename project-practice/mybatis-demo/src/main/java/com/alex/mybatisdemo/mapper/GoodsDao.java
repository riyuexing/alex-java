package com.alex.mybatisdemo.mapper;

import com.alex.mybatisdemo.entity.GoodsDo;
import org.springframework.stereotype.Repository;

/**
 * @author alex
 * @version 1.0
 * @description: 商品数据库访问接口
 * @date 2023/1/21 9:14
 */
@Repository // 标注数据访问组件
public interface GoodsDao {
    /**
     * 新增商品 *
     * @param goods
     * @return
     */
    public int insert(GoodsDo goods);
}
