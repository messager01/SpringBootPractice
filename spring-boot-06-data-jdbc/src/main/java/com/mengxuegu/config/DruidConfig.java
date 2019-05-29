package com.mengxuegu.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    //  注入  druid  连接池的属性
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return  new DruidDataSource();
    }


    //  配置druid监控
    // 1. 配置一个druid的后台  管理servlet
    //  2.  配置druid的filter


    @Bean
    public ServletRegistrationBean statViewServlet(){
        // 让请求为  /druid/*  的请求都 映射到该servlet
        ServletRegistrationBean<StatViewServlet> bean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
       //  设置初始化参数
        Map<String,String> initParam = new HashMap<>();
        initParam.put(StatViewServlet.PARAM_NAME_USERNAME,"root");
        initParam.put(StatViewServlet.PARAM_NAME_PASSWORD,"root");
        // 如果不写  则默认所有的IP都可以访问
        initParam.put(StatViewServlet.PARAM_NAME_ALLOW,"");
            //  拒绝访问的IP
        initParam.put(StatViewServlet.PARAM_NAME_DENY,"");

        bean.setInitParameters(initParam);
        return bean;

    }

    // 2. 配置一个druid的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());

        Map<String, String> initParams = new HashMap<>();
        initParams.put(WebStatFilter.PARAM_NAME_EXCLUSIONS,"*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        // 设置拦截请求
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
