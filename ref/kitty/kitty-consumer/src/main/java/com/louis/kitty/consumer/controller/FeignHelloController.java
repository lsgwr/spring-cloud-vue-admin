package com.louis.kitty.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.louis.kitty.consumer.feign.KittyProducerService;

@RestController
public class FeignHelloController {

    @Autowired
    private KittyProducerService kittyProducerService;
    
    @RequestMapping("/feign/call")
    public String call() {
        // 像调用本地服务一样
        return kittyProducerService.hello();
    }
}