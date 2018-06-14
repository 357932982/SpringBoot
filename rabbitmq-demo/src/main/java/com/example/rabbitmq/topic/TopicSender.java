package com.example.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TopicSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send() {
		String context = "hi, i am message_all";
		System.out.println("Sender: "+context);
		rabbitTemplate.convertAndSend("TopicExchange", "topic.all", context);
	}
	
	public void send1() {
		String context = "hi, i am message_01";
		System.out.println("Sender: "+context);
		rabbitTemplate.convertAndSend("TopicExchange", "topic.message_01", context);
	}
	
	public void send2() {
		String context = "hi, i am message_02";
		System.out.println("Sender: "+context);
		rabbitTemplate.convertAndSend("TopicExchange", "topic.message_02", context);
	}

}
