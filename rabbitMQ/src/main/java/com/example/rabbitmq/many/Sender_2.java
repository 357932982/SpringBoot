package com.example.rabbitmq.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender_2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i){
        String context = "sender_2, hello "+ i +" "+ new Date();
        System.out.println("Sender_2: "+context);
        rabbitTemplate.convertAndSend("one2many", context);
    }
}
