package com.example.rabbitmq.object;

import com.example.rabbitmq.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendUser {

    @Autowired
    private AmqpTemplate rabbitMQTemplate;

    public void send(User user){
        System.out.println("Send: "+user);
        rabbitMQTemplate.convertAndSend("obj", user);
    }
}
