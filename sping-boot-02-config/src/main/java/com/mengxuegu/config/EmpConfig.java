package com.mengxuegu.config;


import com.mengxuegu.service.EmpService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration      //  用于标识当前类是一个标识类
public class EmpConfig {

    /*
    *     返回值就是注入容器中的组件对象
    *     方法名就是这个组件的  id
    * */

    @Bean    //  标识的方法用于向容器中注入组件
    public EmpService empService2(){
        System.out.println("测试empService组件");
        return new EmpService();
    }
}
