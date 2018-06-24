package com.example.taskdemo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
 * Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
 * Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
 */

@Component
public class SchedulerTask_02 {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 2000)
    public void process() {
        System.out.println("现在时间：" + simpleDateFormat.format(new Date()));
    }
}
