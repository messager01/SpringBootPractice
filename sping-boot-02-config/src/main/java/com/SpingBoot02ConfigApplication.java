package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


/*
* @ImportResource(locations = {"classpath:applicationContext.xml"})  用于加载spring的配置文件并把它加载到容器中
* */
@ImportResource(locations = {"classpath:applicationContext.xml"})
@SpringBootApplication
public class SpingBoot02ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingBoot02ConfigApplication.class, args);
    }

}
