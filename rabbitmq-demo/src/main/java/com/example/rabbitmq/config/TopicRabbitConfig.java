package com.example.rabbitmq.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //用来将类注入spring容器中
public class TopicRabbitConfig {

	final static String MESSAGE_01 = "topic.message_01";
	final static String MESSAGE_02 = "topic.message_02";
	final static String EXCHANGE = "TopicExchange";
	
	/**
	 * 配置消息队列
	 */
	@Bean
	public Queue queueMessage_01() {
		return new Queue(TopicRabbitConfig.MESSAGE_01);
	}
	
	/**
	 * 配置消息队列
	 */
	@Bean
	public Queue queueMessage_02() {
		return new Queue(TopicRabbitConfig.MESSAGE_02);
	}
	
	/**
	 * 配置交换机
	 */
	@Bean
	TopicExchange exchange() {
		return new TopicExchange(TopicRabbitConfig.EXCHANGE);
	}
	
	/**
	 * 设置交换机、队列、路由键
	 * @param queueMessage
	 * @param exchange
	 * @return
	 */
	@Bean
	Binding bindingExchangeMessage_01(Queue queueMessage, TopicExchange exchange) {
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
	}
	
	@Bean
	Binding bindingExchangeMessage_02(Queue queueMessage, TopicExchange exchange) {
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.#");
	}
}
