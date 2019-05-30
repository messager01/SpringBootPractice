package com.mengxuegu.service;/*
 *
 *  @Author:shipeixin
 *  @Date:2019/5/30 13:12
 *
 *    创建定时任务
 */


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    private static int count = 1;

    /*
    *      "0          *       *       *       *        MON-FRI"   cron表达式
    *      second    minute  hour     day      month    week
    *
    * */
    @Scheduled(cron = "1-30 * * * * MON-FRI")
    public void dataCount(){
        System.out.println("数据统计第"+(count++)+"次");
    }

}
