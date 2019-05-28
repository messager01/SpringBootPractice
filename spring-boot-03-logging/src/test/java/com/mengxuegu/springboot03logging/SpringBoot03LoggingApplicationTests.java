package com.mengxuegu.springboot03logging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03LoggingApplicationTests {

        // 生成日志记录器                        获得当前类
        Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads() {

        //  日志信息级别   由低到高   trace < debug  <  info  <   warn   <  error
        //  springboot  默认设置级别为info  又称root级别
        //  可以通过配置文件进行修改日志级别  设置某一个界别之后  就只打印  《= 该级别的日志
        //  没有指定级别的就用springboot的默认级别

          //  跟踪运行信息
        logger.trace("这是trace日志信息");
        //  调试信息
        logger.debug("这是debug信息");
        // 自定义信息
        logger.info("这是info日志信息");
        //警告信息
        logger.warn("warn 日志信息");
        //  错误信息
        logger.error("error  信息");
    }

}
