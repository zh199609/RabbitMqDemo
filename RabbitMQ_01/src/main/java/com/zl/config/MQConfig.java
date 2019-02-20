package com.zl.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建消息队列
 */
@Configuration
public class MQConfig {

    @Bean
    public Queue createQueue() {
        return new Queue("msg-queue");
    }

}
