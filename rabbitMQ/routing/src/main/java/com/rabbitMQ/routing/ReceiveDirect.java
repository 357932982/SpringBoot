package com.rabbitMQ.routing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class ReceiveDirect {

    private static final String EXCHANGE_NAME = "direct";

    public static void main(String[] args) throws IOException, TimeoutException {

        ArrayList<String> sev = new ArrayList<String>();
        while (true) {
            System.out.print("请输入severity:");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            sev.add(str);
            if ("exit".equals(str)) {
                break;
            }
        }

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.196.132");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        String queueName = channel.queueDeclare().getQueue();

        if (sev.size() < 1) {
            System.err.println("Usage: ReceiveDirect [info] [warning] [error]");
            System.exit(1);
        }

        //设置路由关键字
        for (String severity : sev) {
            channel.queueBind(queueName, EXCHANGE_NAME, severity);
        }
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "utf-8");
                System.out.println("[x] received '" + envelope.getRoutingKey() + ":" + message + "'");
            }

            ;
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
