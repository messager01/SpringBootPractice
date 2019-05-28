package com.mengxuegu.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;


@PropertySource(value = {"classpath:emp.properties"})    //  加载局部配置文件
@Validated    //数据校验
@Component       //  将当前组件交由spring管理
@Data
//@ConfigurationProperties  告诉springboot 将配置文件中对应的属性值，映射到这个类当中
@ConfigurationProperties(prefix = "emp")     // 映射文件中属性的前缀名
public class Emp {

    /*
    *   类似于spring 中使用配置文件中的数据注入方式
    * */
//    @Value("${emp.last-name}")    //  获取属性文件的key值对应的value
    //@Email   //  检验是否为邮箱
    private String lastName;
//    @Value("#{10*2}")     //  使用SPEL 表达式
    private Integer age;
//    @Value("8000")          //  直接注入常量
    private Double salary;

    private Boolean boss;

    private Date birthday;

    private Map map;

    private List list;

    private Forte forte;
}

/*
* 总结  使用场景：
*    如果只是在某个业务逻辑中需要获取配置文件中的某个属性值，就使用 @Value
*
*    如果专门使用javaBean和配置文件进行映射，就使用 @ConfigurationProperties
*
* */