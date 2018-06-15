package com.example.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout_queue_02")
public class FanoutReceiver_02 {

    @RabbitHandler
    public void process(String message){
        System.out.println("FanoutReceiver_02"+message);
    }
}
