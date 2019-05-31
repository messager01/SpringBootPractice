package com.mengxuegu.config;/*
 *
 *  @Author:shipeixin
 *  @Date:2019/5/30 20:00
 *
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisConfig {


    @Bean
    public RedisTemplate<Object,Object> jsonRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer(Object.class));
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
