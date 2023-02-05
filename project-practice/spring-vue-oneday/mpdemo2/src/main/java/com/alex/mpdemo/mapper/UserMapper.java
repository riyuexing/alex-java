package com.alex.mpdemo.mapper;

import com.alex.mpdemo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author alex
 * @version 1.0
 * @description: TODO
 * @date 2023/2/4 22:22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
//
//    /**
//     * 增加用户 *
//     * @param user
//     * @return
//     */
//    @Insert("insert into user values(#{id}, #{username}, #{password}, #{phone}, #{mail})")
//    int add(User user);
//
//    /**
//     * 更新用户信息 *
//     * @param user
//     * @return
//     */
//    @Update("update user set username=#{username}, password=#{password}, phone=#{phone}, mail=#{mail} where id=#{id}")
//    int update(User user);
//
//
//    /**
//     * 删除指定id的用户*
//     * @param id
//     * @return
//     */
//    @Delete("delete from user where id=#{id}")
//    int deleteById(int id);
//
//    /**
//     * 根据id查询用户 *
//     * @param id
//     * @return
//     */
//    @Select("select * from user where id=#{id}")
//    User findById(int id);
//
//    /**
//     * 查询所有用户 *
//     * @return
//     */
//    @Transactional(rollbackFor = Exception.class)
//    @Select("select * from user")
//    List<User> findAll();
}
