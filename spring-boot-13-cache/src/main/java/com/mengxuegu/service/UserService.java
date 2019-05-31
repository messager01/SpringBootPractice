package com.mengxuegu.service;/*
 *
 *  @Author:shipeixin
 *  @Date:2019/5/30 17:09
 *
 */

import com.mengxuegu.entities.User;
import com.mengxuegu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    /*
    *   cacheNames   缓存容器的名字
    *   key 为容器中的key值
    * */
    @Cacheable(cacheNames = "user",key = "#id")   //  不指定key，默认使用传进去的参数为key   这里就默认使用id为key
    public User getUserById(Integer id){
        User user = userMapper.getUserById(id);
        return user;
    }

                     //            指定id作为key值
    @CachePut(cacheNames = "user",key = "#user.id")   //  更新缓存容器中的数据   必须写cacheNames  否则会报错
    public User updateUser(User user){
        userMapper.updateUser(user);
        return user;
    }

    /*
    *   总结：
    *    生成缓存   和  更新缓存  两个的缓存容器名字一定要一样
    *    且  缓存的主键必须得一致，这样才能更新缓存
    *
    * */


    /*
     *   默认情况下删除   只能删除数据库中的数据   并不能删除缓存中的数据
     * */




    /*
    *     其他参数：
    *     allEntries = true     会删除缓存中的所有数据
    *     beforeInvocation = true    在执行该方法之前就清空缓存   （默认的是在方法调用之后再删除缓存）
    *
     * */
    @CacheEvict(cacheNames = "user",key = "#id")      //  删除缓存中的数据
    public Integer deleteUserById(Integer id){
        userMapper.deleteUserById(id);
        return id;
    }


    /*
    *
    * 如果启用了redis缓存后  springboot会自动的切换为redis缓存数据
    *
    * */
}
