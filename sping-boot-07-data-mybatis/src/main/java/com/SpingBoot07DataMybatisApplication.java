package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.mengxuegu.mapper")
@SpringBootApplication
public class SpingBoot07DataMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingBoot07DataMybatisApplication.class, args);
    }

}
