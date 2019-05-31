package com.mengxuegu.springboot13cache;

import com.mengxuegu.entities.User;
import com.mengxuegu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot13CacheApplicationTests {

    //  操作的是复杂类型
    @Autowired
    RedisTemplate redisTemplate;

    //  针对的操作的是字符串     一般都使用这个
    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Autowired
    UserService userService;


    //  自定义的json序列化器
    @Autowired
    RedisTemplate jsonRedisTemplate;


    /*
    *
    *    stringRedisTemplate.opsForValue();   //  操作字符串
    *    stringRedisTemplate.opsForList();    //   操作list
    *    stringRedisTemplate.opsForSet();    //    操作set
    *    stringRedisTemplate.opsForZSet();    //  操作zset
    *    stringRedisTemplate.opsForHash();    //  操作hash
    *
    * */

      //  操作简单类型
    @Test
    public void contextLoads() {
        //stringRedisTemplate.opsForValue().set("name","shipeixin");

        //String name = stringRedisTemplate.opsForValue().get("name");
        //System.out.println(name);

        /*
        stringRedisTemplate.opsForList().leftPush("mylist","a");

        stringRedisTemplate.opsForList().leftPushAll("mylist","b","c","d");*/


        List<String> mylist = stringRedisTemplate.opsForList().range("mylist", 0, -1);
        for (String s : mylist) {
            System.out.println(s);
        }


    }



    //  操作复杂类型
    @Test
    public void test1(){
        User user = userService.getUserById(5);
        //  保存的数据为对象  必须  序列化
        //redisTemplate.opsForValue().set("user",user);


        jsonRedisTemplate.opsForValue().set("user2",user);

        /*User user1 = (User) redisTemplate.opsForValue().get("user");
        System.out.println(user1);*/
    }


}
