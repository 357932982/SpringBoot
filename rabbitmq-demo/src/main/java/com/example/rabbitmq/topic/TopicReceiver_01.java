package com.example.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topicQueue_01")
public class TopicReceiver_01 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("topic receive_01: " + message);
    }
}
