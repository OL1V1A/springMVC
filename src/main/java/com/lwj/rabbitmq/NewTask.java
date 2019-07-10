package com.lwj.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auth: lwj
 * @Date: 2019/6/26 14:23
 */
public class NewTask {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.98.117.161");
        factory.setUsername("admin");
        factory.setPassword("admin");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for (int i = 0; i < 10; i++) {
            String message = "lwj :" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("Send message : " + message);
        }
        channel.close();
        connection.close();
    }

}
