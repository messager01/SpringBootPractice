package com.mengxuegu.service;/*
 *
 *  @Author:shipeixin
 *  @Date:2019/5/30 13:05
 *
 * 异步处理  批量操作
 *
 */


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async
public class AsyncService {
    public void batchAdd() throws InterruptedException {
        //  模拟新增数据
        Thread.sleep(3000);
        System.out.println("批量新增数据完成");
    }

}
