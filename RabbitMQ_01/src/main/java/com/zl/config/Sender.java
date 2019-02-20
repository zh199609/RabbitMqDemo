package com.zl.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送方
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送方法的消息
     */
    public void send(String msg) {
        //向消息队列发送消息
        //参数一队列的名称   参数二：消息
        amqpTemplate.convertAndSend("msg-queue", msg);
    }

}
