package com.example.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hi, i am message_all " + new Date();
        System.out.println("Sender: " + context);
        rabbitTemplate.convertAndSend("TopicExchange", "topic.all", context);
    }

    public void send1() {
        String context = "hi, i am message_01 " + new Date();
        System.out.println("Sender: " + context);
        rabbitTemplate.convertAndSend("TopicExchange", "topic.message", context);
    }

}
