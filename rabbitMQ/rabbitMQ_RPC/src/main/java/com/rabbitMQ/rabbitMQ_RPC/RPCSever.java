package com.rabbitMQ.rabbitMQ_RPC;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class RPCSever {
	
	private static final String RPC_QUEUE_NAME = "rpc_queue";
	
	private static int  fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
	
	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.196.132");
		factory.setPort(5672);
		factory.setUsername("admin");
		factory.setPassword("admin");
		Connection connection = null;
		try {
			connection = factory.newConnection();
			final Channel channel = connection.createChannel();
			channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);
			
			channel.basicQos(1);
			
			System.out.println(" [x] Awaiting RPC requests");
			
			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, 
										Envelope envelope, 
										BasicProperties properties, 
										byte[] body) throws java.io.IOException {
					BasicProperties replayProps = new BasicProperties().builder()
												.correlationId(properties.getCorrelationId())
												.build();
					String response = "";
					try {
						String message = new String(body, "utf-8");
						int n = Integer.parseInt(message);
						
						System.out.println(" [.] fib(" + message + ")");
						response += fib(n);
					} catch (Exception e) {
						System.out.println(" [.] " + e.toString());
					} finally {
						channel.basicPublish("", properties.getReplyTo(), replayProps, response.getBytes("utf-8"));
						channel.basicAck(envelope.getDeliveryTag(), false);
						synchronized (this) {
							this.notify();
						}
					}
				};
			};
			
			channel.basicConsume(RPC_QUEUE_NAME, false, consumer);
			
			while (true) {
				synchronized (consumer) {
					try {
						consumer.wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
