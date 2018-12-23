package com.huawei.l00379880.userservice.client;

import com.huawei.l00379880.userservice.client.hystrix.AuthServiceHystrix;
import com.huawei.l00379880.userservice.entity.JWT;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "uaa-service",fallback = AuthServiceHystrix.class )
public interface AuthServiceClient {

    @PostMapping(value = "/oauth/token")
    JWT getToken(@RequestHeader(value = "Authorization") String authorization, @RequestParam("grant_type") String type,
                 @RequestParam("username") String username, @RequestParam("password") String password);
}



