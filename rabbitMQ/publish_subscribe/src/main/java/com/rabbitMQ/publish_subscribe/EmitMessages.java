package com.rabbitMQ.publish_subscribe;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitMessages {

    private static final String EXCHANGE_NAME = "messages";

    public static void main(String[] args) throws IOException, TimeoutException {
        while (true) {

            System.out.print("请输入：");
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

            //定义交换机名称和交换机输出模式，FANOUT类似于广播
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

            String message = getMessage(strings);

            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");

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
}
