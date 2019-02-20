package com.zl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MQTest {



    @Autowired
    private OrderSender orderSender;

    @RequestMapping(value = "order/{msg}")
    public String order(@PathVariable(value = "msg") String msg){
        orderSender.send(msg);
        return "SUCCESS";
    }
}
