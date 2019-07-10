package com.lwj.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auth: lwj
 * @Date: 2019/6/26 13:38
 */
public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ的主机名
        factory.setHost("47.98.117.161");
//        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
        //创建一个连接
        Connection connection = factory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        //指定一个队列
        // 参数1 queue ：队列名
        // 参数2 durable ：是否持久化
        // 参数3 exclusive ：仅创建者可以使用的私有队列，断开后自动删除
        // 参数4 autoDelete : 当所有消费客户端连接断开后，是否自动删除队列
        // 参数5 arguments
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //发送消息
        String message = "Hello World!";
        // 参数1 exchange ：交换器
        // 参数2 routingKey ： 路由键
        // 参数3 props ： 消息的其他参数
        // 参数4 body ： 消息体
        channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        //关闭频道和连接
        channel.close();
        connection.close();


    }
}
