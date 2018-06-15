package com.example.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout_queue_01")
public class FanoutReceiver_01 {

    @RabbitHandler
    public void process(String message){
        System.out.println("FanoutReceiver_01"+message);
    }
}
