package com.mengxuegu.service;/*
 *
 *  @Author:shipeixin
 *  @Date:2019/5/31 13:39
 *
 */


import com.mengxuegu.entities.Provider;
import com.mengxuegu.mapper.ProviderMapper;
import com.mengxuegu.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {

    @Autowired
    ProviderMapper providerMapper;

    //  自己封装的redis的工具类
    @Autowired
    RedisClient redisClient;

    public Provider getProviderByPid(Integer pid){
        //  先查询缓存中是否有数据
        Object obj = redisClient.get(pid);
        if(obj != null){   // 说明redis中有数据
           return (Provider)obj;
        }
        Provider provider = providerMapper.getProviderByPid(pid);
        //  查询出来后  添加到缓存中
        redisClient.set(pid,provider);
        return provider;
    }


    public Integer updateProvider(Provider provider){
        Integer integer = providerMapper.updateProvider(provider);
        if (integer > 0){ // 说明更新成功
            redisClient.set(provider.getPid(),provider);
        }
        return integer;
    }

    public Integer addProvider(Provider provider){
        Integer integer = providerMapper.addProvider(provider);
        // 判断数据库是否添加  如果数据库添加  再更新redis中的数据
        if(integer > 0){   // 数据库已更新
            redisClient.set(provider.getPid(),provider);
        }
        return integer;
    }


    public Integer deleteProvider(Integer pid){
        Integer integer = providerMapper.deleteProvider(pid);
        if (integer > 0){  // 数据库删除成功
            redisClient.del(pid);   // 清除缓存
        }
        return integer;
    }

}
