package com.lwj.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * @Auth: lwj
 * @Date: 2019/6/26 15:34
 */
public class EmitLogDirect {


    private final static String EXCHANGE_NAME = "logs-direct";
    private final static String[] LOG_LEVEL = {"debug", "info", "error"};

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.98.117.161");
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        for (int i = 0; i < 10; i++) {
            int radom = new Random().nextInt(3);
            String severity = LOG_LEVEL[radom];
            String message = "LOG : [" + severity + "]" + UUID.randomUUID().toString();
            channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
            System.out.println("发送：" + message);
        }
        channel.close();
        connection.close();
    }

}
