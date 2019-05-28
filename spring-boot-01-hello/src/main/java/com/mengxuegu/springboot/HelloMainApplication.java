package com.mengxuegu.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
*   会自动扫面启动类所在包及其子包的组件，交由Spring管理
*
*   SpringBootApplication这个注解   实际上包含了下列三个注解
*
*   @SpringBootConfiguration
*       @Configuration  它属于spring的一个注解  定义配置类  等同于配置文件
*           @Component  添加到spring容器当中 ，表示是一个组件
*
*
*   @EnableAutoConfiguration
*        @AutoConfigurationPackage   表示将引导类所在包及其子包的组件添加到Spring容器中
*        @Import({AutoConfigurationImportSelector.class})  1.将所有组件以全类名的方式返回并添加到spring容器
*                                                          2.会给容器中导入很多的自动配置类
*
*
*   @ComponentScan   被该注解标识的类，会被spring管理，也就是让引导类被spring管理
*
*
* */
@SpringBootApplication          //  用于标识一个引导类  说明是一个springboot项目
public class HelloMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloMainApplication.class,args);
    }
}
