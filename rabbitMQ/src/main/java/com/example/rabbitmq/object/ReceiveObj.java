package com.example.rabbitmq.object;

import com.example.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "obj")
public class ReceiveObj {

    @RabbitHandler
    public void process(User user){
        System.out.println("Receiver: "+user);
    }
}
