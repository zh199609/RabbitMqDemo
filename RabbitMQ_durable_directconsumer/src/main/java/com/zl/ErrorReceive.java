package com.zl;


import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
/*
    bindings = {}  绑定队列
    @QueueBinding   value:绑定队列的名称
                    exchange:配置交换器
    @Queue  value:配置队列名称
            autoDelete:是否是一个可删除的临时队列
    @Exchange   value:为交换器起个名称
                type：指定交换器类型
 */
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.error}", autoDelete = "false"),
                exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.DIRECT),
                key = "${mq.config.queue.error.routing.key}"
        )
)
public class ErrorReceive {


    @RabbitHandler
    public void process(String msg) {
        System.out.println("error receive:" + msg);
    }

}
