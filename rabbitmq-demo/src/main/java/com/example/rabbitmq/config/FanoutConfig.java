package com.example.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    private final static String QUEUE_01 = "fanout_queue_01";
    private final static String QUEUE_02 = "fanout_queue_02";
    private final static String QUEUE_03 = "fanout_queue_03";

    private final static String FANOUT_EXCHANGE = "fanout_exchange";

    @Bean
    public Queue queue_01(){
        return new Queue(QUEUE_01);
    }

    @Bean
    public Queue queue_02(){
        return new Queue(QUEUE_02);
    }

    @Bean
    public Queue queue_03(){
        return new Queue(QUEUE_03);
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    Binding bindingFanout_01(Queue queue_01, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue_01).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanout_02(Queue queue_02, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue_02).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanout_03(Queue queue_03, FanoutExchange exchange){
        return BindingBuilder.bind(queue_03).to(exchange);
    }
}
