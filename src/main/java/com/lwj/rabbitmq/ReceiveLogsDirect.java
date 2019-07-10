package com.lwj.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * @Auth: lwj
 * @Date: 2019/6/26 15:39
 */
public class ReceiveLogsDirect {


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
        int radom = new Random().nextInt(3);
        String severity = LOG_LEVEL[radom];
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, severity);
        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Received :" + message);
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
