package com.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/*
*      增强mvc的功能
*  1.  创建一个类  实现 WebMvcConfigurer接口
*  2.  在对应的类上用@Configuration表示   表明是一个配置类
*  3.  不能用@EnableMvc标识
*
* */

//  加上 @EnableWebMvc 注解 自动配置就完全作废  得自己完全掌控MVC配置  不建议使用
//@EnableWebMvc
@Configuration
public class MySpringMVCConfig implements WebMvcConfigurer {

    //  增加视图控制
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //  发送mengxuegu请求  回来到  success
        registry.addViewController("/mengxuegu").setViewName("success");
    }
}
