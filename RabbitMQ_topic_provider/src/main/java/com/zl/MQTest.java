package com.zl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MQTest {

    @Autowired
    private UserSender userSender;

    @Autowired
    private ProductSender productSender;

    @Autowired
    private OrderSender orderSender;

    @RequestMapping(value = "user/{msg}")
    public String user(@PathVariable(value = "msg") String msg){
        userSender.send(msg);
        return "SUCCESS";
    }


    @RequestMapping(value = "product/{msg}")
    public String product(@PathVariable(value = "msg") String msg){
        productSender.send(msg);
        return "SUCCESS";
    }

    @RequestMapping(value = "order/{msg}")
    public String order(@PathVariable(value = "msg") String msg){
        orderSender.send(msg);
        return "SUCCESS";
    }
}
