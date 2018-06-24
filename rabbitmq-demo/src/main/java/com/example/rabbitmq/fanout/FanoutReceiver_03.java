package com.example.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout_queue_03")
public class FanoutReceiver_03 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("FanoutReceiver_03" + message);
    }
}
