package com.zl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送方
 */
@Component
public class ProductSender {

    @Autowired
    private AmqpTemplate amqpTemplate;
    //交换器名称
    @Value("${mq.config.exchange}")
    private String exchangeName;

    /**
     * 发送方法的消息
     */
    public void send(String msg) {
        //向消息队列发送消息
        //参数一：交换器名称
        //参数二：路由键
        //参数三：消息
        amqpTemplate.convertAndSend(exchangeName, "product.log.debug", "product.log.debug……" + msg);
        amqpTemplate.convertAndSend(exchangeName, "product.log.info", "product.log.info……" + msg);
        amqpTemplate.convertAndSend(exchangeName, "product.log.warn", "product.log.warn……" + msg);
        amqpTemplate.convertAndSend(exchangeName, "product.log.error", "product.log.error……" + msg);


    }

}
