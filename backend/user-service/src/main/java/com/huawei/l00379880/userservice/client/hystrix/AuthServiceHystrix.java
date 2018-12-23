package com.huawei.l00379880.userservice.client.hystrix;


import com.huawei.l00379880.userservice.client.AuthServiceClient;
import com.huawei.l00379880.userservice.entity.JWT;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceHystrix implements AuthServiceClient {
    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        System.out.println("--------opps getToken hystrix---------");
        return null;
    }
}
