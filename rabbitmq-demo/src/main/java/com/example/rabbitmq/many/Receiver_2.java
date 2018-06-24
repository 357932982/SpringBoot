package com.example.rabbitmq.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "one2many")
public class Receiver_2 {

    @RabbitHandler
    public void process(String string) {
        System.out.println("Receiver_2: " + string);
    }
}
