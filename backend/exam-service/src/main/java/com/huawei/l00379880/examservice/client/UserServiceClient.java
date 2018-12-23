package com.huawei.l00379880.examservice.client;

import com.huawei.l00379880.common.dto.RespDTO;
import com.huawei.l00379880.examservice.client.hystrix.UserServiceHystrix;
import com.huawei.l00379880.examservice.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;


/**
 * Created by liangshanguang on 2018-12-23 21:30
 */

@FeignClient(value = "user-service",fallback = UserServiceHystrix.class )
public interface UserServiceClient {

    @PostMapping(value = "/user/{username}")
    RespDTO<User> getUser(@RequestHeader(value = "Authorization") String token, @PathVariable("username") String username);
}



