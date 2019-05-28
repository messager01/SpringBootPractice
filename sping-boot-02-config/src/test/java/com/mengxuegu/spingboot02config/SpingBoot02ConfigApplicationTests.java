package com.mengxuegu.spingboot02config;

import com.mengxuegu.bean.Emp;
import com.mengxuegu.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpingBoot02ConfigApplicationTests {

    @Autowired
    Emp emp;

    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
        System.out.println(emp);
    }


    @Test
    public void testXml(){
        EmpService empService = (EmpService) context.getBean("empService");
        System.out.println(empService);
        empService.add();
    }


    @Test
    public void test2(){
        EmpService empService2 = (EmpService) context.getBean("empService2");
        empService2.add();
    }

}
