package com.example.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "你好， 小明: " + new Date();
        System.out.println("fanoutSender:"+context);
        rabbitTemplate.convertAndSend("fanout_exchange", "", context);
    }
}
