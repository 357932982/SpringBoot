package com.rabbitMQ.queue;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class NewTask {
	private static final String TASK_QUEUE_NAME = "task_queue";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		while (true) {
			
			System.out.println("请输入：");
			Scanner input = new Scanner(System.in);
			String strings = input.nextLine();
			if ("exit".equals(strings)) {
				System.exit(0);
			}
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("192.168.196.132");
			factory.setPort(5672);
			factory.setUsername("admin");
			factory.setPassword("admin");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
			
			String message = getMessage(strings);
			
			channel.basicPublish("", TASK_QUEUE_NAME, 
					MessageProperties.PERSISTENT_TEXT_PLAIN, 
					message.getBytes("UTF-8"));
			System.out.println("[X] sent '"+message+"'");
			channel.close();
			connection.close();
		}
		
	}
	
	private static String getMessage(String strings) {
		if (strings.length() < 1) {
			return "Hello RabbitMQ!";
		}
		return strings;
	}
	
//	private static String joinStrings(String[] strings, String delimiter) {
//		int length = strings.length;
//		if (length == 0) {
//			return "";
//		}
//		StringBuilder words = new StringBuilder(strings[0]);
//		for (int i = 0; i < length; i++) {
//			words.append(delimiter).append(strings[i]);
//		}
//		return words.toString();
//	}
}
