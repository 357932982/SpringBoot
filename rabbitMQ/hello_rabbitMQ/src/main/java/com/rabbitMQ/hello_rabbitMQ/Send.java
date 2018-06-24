package com.rabbitMQ.hello_rabbitMQ;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
//		创建连接工厂类
        ConnectionFactory factory = new ConnectionFactory();
//		设置连接rabbitMQ的链接地址、账号、密码
        factory.setHost("192.168.154.129");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
//		建立一个与rabbitMQ的连接
        Connection connection = factory.newConnection();
//		在连接中建立通道
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello rabbitMQ!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("[x] sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
