package com.louis.kitty.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "kitty-producer", fallback = KittyProducerHystrix.class)
public interface KittyProducerService {

    @RequestMapping("/hello")
    public String hello();
}
