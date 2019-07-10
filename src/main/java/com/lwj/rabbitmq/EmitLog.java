package com.lwj.rabbitmq;

import com.rabbitmq.client.*;
import com.rabbitmq.client.impl.AMQImpl;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auth: lwj
 * @Date: 2019/6/26 15:12
 */
public class EmitLog {

    private final static String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.98.117.161");
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String message = "日志消息通知";
        channel.basicPublish(EXCHANGE_NAME, "", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        System.out.println("发送：" + message);
        channel.close();
        connection.close();
    }

}
