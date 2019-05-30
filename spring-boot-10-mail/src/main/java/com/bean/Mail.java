package com.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@PropertySource(value = {"classpath:mail.properties"})    //  加载局部配置文件
@Component       //  将当前组件交由spring管理
public class Mail {


    @Value("${mail.subject}")    //  获取属性文件的key值对应的value
    private String subject;

    @Value("${mail.text}")
    private String text;

    @Value("${mail.from}")
    private String from;


    @Value("${mail.to}")
    private String to;

    @Value("${mail.priname}")
    private String picname;

    @Value("${mail.picloacation}")
    private String picloacation;
}
