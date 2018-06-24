package com.example.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    /**
     * 配置消息队列
     *
     * @return
     */
    @Bean
    public Queue myQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue myQueue_1() {
        return new Queue("one2many");
    }

    @Bean
    public Queue myQueue_2() {
        return new Queue("obj");
    }
}
