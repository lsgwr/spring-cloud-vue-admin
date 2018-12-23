package com.huawei.l00379880.examservice.client.hystrix;

import com.huawei.l00379880.common.dto.RespDTO;
import com.huawei.l00379880.examservice.client.UserServiceClient;
import com.huawei.l00379880.examservice.entity.User;
import org.springframework.stereotype.Component;


/**
 * Created by liangshanguang on 2018-12-23 21:30
 */
@Component
public class UserServiceHystrix implements UserServiceClient {

    @Override
    public RespDTO<User> getUser(String token, String username) {
        System.out.println(token);
        System.out.println(username);
        return null;
    }
}
