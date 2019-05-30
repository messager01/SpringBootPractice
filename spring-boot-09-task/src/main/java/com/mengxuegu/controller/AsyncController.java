package com.mengxuegu.controller;/*
 *
 *  @Author:shipeixin
 *  @Date:2019/5/30 13:06
 *
 */


import com.mengxuegu.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;


    @GetMapping("/hello")
    public String hello() throws InterruptedException {
        asyncService.batchAdd();
        return "success";
    }
}
