package com.alex.mybatisdemo.mapper;

import com.alex.mybatisdemo.entity.GoodsDo;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 删除商品(根据id)*
     */
    public int delete(Long id);

    /**
     * 修改商品信息(根据id修改其他属性值) *
     * @param goods
     * @return
     */
    public int update(GoodsDo goods);

    /**
     * 根据id选择商品 *
     * @param id
     * @return
     */
    public GoodsDo selectOne(Long id);

    /**
     * 查询所有商品 *
     * @return
     */
    public List<GoodsDo> selectAll();
}
