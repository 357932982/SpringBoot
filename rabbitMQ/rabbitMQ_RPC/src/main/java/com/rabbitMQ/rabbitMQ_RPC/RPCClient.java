package com.rabbitMQ.rabbitMQ_RPC;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class RPCClient {
	
	private Connection connection;
	private Channel channel;
	private String requestQueueName = "rpc_queue";
	private String replyQueueName;
	
	public RPCClient() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.196.132");
		factory.setPort(5672);
		factory.setUsername("admin");
		factory.setPassword("admin");
		
		connection = factory.newConnection();
		channel = connection.createChannel();
		
		replyQueueName = channel.queueDeclare().getQueue();
		
	}
	
	public String call(String message) throws UnsupportedEncodingException, IOException, InterruptedException {
		final String corrId = UUID.randomUUID().toString();
		
		BasicProperties props = new BasicProperties()
								.builder()
								.correlationId(corrId)
								.replyTo(replyQueueName)
								.build();
		
		channel.basicPublish("", requestQueueName, props, message.getBytes("utf-8"));
		
		final BlockingQueue<String> response = new ArrayBlockingQueue<String>(1);
		
		channel.basicConsume(replyQueueName, true, new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, 
									Envelope envelope, 
									BasicProperties properties, 
									byte[] body) throws IOException {
				if (properties.getCorrelationId().equals(corrId)) {
					response.offer(new String(body, "utf-8"));
				}
			}
		});
		return response.take();
	}
	
	public void close() throws IOException, TimeoutException {
		channel.close();
		connection.close();
	}
	
	public static void main(String[] args) {
		RPCClient fib = null;
		String response = null;
		try {
			fib = new RPCClient();
			
			System.out.println(" [x] Requesting fib(30)");
			response = fib.call("30");
			System.out.println(" [.] Got '" + response + "'");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fib != null) {
				try {
					fib.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}

}
