package com.alex.mybatisdemo;

import com.alex.mybatisdemo.entity.GoodsDo;
import com.alex.mybatisdemo.mapper.GoodsDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MybatisDemoApplicationTests {

    @Autowired
    private GoodsDao goodsDao;

    @Test
    void contextLoads() {
    }

    @Test
    void test_01(){
        GoodsDo goods = new GoodsDo();
        goods.setName("手机1");
        goods.setPic("phone1.jpg");
        goods.setPrice("3000");
        int count = goodsDao.insert(goods);
        assertEquals(1,count);

    }

}
