package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync          //  开启基于注解版的异步处理
@EnableScheduling     //  开启注解版定时任务
public class SpringBoot09TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot09TaskApplication.class, args);
    }

}
