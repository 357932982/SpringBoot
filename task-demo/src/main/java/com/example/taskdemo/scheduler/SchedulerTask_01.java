package com.example.taskdemo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask_01 {

    private Integer count = 0;

    @Scheduled(cron = "*/1 * * * * ?")
    public void process(){
        System.out.println("this is scheduler task running: "+ count++);
    }

}
