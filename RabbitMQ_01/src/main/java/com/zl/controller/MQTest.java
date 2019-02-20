package com.zl.controller;

import com.zl.config.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MQTest {

    @Autowired
    private Sender sender;
    @RequestMapping(value = "test/{msg}")
    public String test1(@PathVariable(value = "msg") String msg){
        System.out.println("-----------------------"+msg);
        sender.send(msg);
        return "SUCCESS";
    }
}
