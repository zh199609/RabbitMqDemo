package com.zl.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 */
@Component
public class Receive {

    @RabbitListener(queues = "msg-queue")
    public void process(String msg){
        System.out.println("接收到的消息："+msg);
    }
}
