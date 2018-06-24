package com.example.rabbitmq.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //用来将类注入spring容器中
public class TopicRabbitConfig {

    private final static String QUEUE_01 = "topicQueue_01";
    private final static String QUEUE_02 = "topicQueue_02";
    private final static String EXCHANGE = "TopicExchange";

    /**
     * 配置消息队列
     */
    @Bean
    public Queue queueMessage_01() {
        return new Queue(TopicRabbitConfig.QUEUE_01);
    }

    /**
     * 配置消息队列
     */
    @Bean
    public Queue queueMessage_02() {
        return new Queue(TopicRabbitConfig.QUEUE_02);
    }

    /**
     * 配置交换机
     */
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TopicRabbitConfig.EXCHANGE);
    }

    /**
     * 设置交换机、队列、路由键
     */
    @Bean
    Binding bindingExchangeMessage_01(Queue queueMessage_01, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueMessage_01).to(topicExchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessage_02(Queue queueMessage_02, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueMessage_02).to(topicExchange).with("topic.#");
    }
}
