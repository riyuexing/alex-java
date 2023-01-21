package com.alex.mybatisdemo;

import com.alex.mybatisdemo.entity.GoodsDo;
import com.alex.mybatisdemo.mapper.GoodsDao;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MybatisDemoApplicationTests {

    @Autowired
    private GoodsDao goodsDao;

    @Test
    void contextLoads() {
    }

    private Long currentId=8L;

    /**
     * 新增商品 *
     */
    @Test
    @Order(1)
    void test_01(){
        GoodsDo goods = new GoodsDo();
        goods.setName("手机1");
        goods.setPic("phone1.jpg");
        goods.setPrice("3000");
        goods.setCreateTime(new Date());
        int count = goodsDao.insert(goods);
        assertEquals(1,count);
    }

    /**
     * 更新商品信息*
     */
    @Test
    @Order(2)
    void test_02(){
        GoodsDo goods = new GoodsDo();
        goods.setId(currentId);
        goods.setName("手机1");
        goods.setPic("phone1.jpg");
        goods.setPrice("4000");
        goods.setCreateTime(new Date());
        int count = goodsDao.update(goods);
        assertEquals(1,count);
    }

    /**
     * 获取商品信息 *
     */
    @Test
    @Order(3)
    void test_03(){
        GoodsDo goods = goodsDao.selectOne(currentId);
        assertNotNull(goods);
    }

    /**
     * 删除商品 *
     */
    @Test
    @Order(4)
    void test_04(){
        int count = goodsDao.delete(currentId);
        assertEquals(1,count);
    }

    /**
     * 获取商品列表 *
     */
    @Test
    void test_05(){
        List<GoodsDo> goodsList = goodsDao.selectAll();
        assertEquals(0,goodsList.size());
    }

}
