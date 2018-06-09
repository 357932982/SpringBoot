package com.rabbitMQ.routing;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitDirect {

	private static final String EXCHANGE_NAME = "direct";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		while(true) {
			
			System.out.print("请输入severity:");
			Scanner scanner = new Scanner(System.in);
			String str	= scanner.nextLine();
			System.out.println();
			System.out.print("请输入message:");
			Scanner scanner1 = new Scanner(System.in);
			String strings	= scanner1.nextLine();
			
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("192.168.196.132");
			factory.setPort(5672);
			factory.setUsername("admin");
			factory.setPassword("admin");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			
			channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
			
			String severity = getSeverity(str);
			String message = getMessage(strings);
			
			channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes("utf-8"));
			System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
			
			channel.close();
			connection.close();
		}
		
	}
	private static String getSeverity(String str) {
		if (str.length() < 1) {
			return "info";
		}
		return str;
	}
	
	private static String getMessage(String strings) {
		if (strings.length() < 1) {
			return "Hello RabbitMQ!";
		}
		return strings;
	}
}
