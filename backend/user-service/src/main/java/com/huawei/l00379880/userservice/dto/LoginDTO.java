package com.huawei.l00379880.userservice.dto;

import com.huawei.l00379880.userservice.entity.User;

/**
 * Created by liangshanguang at 2018-12-24 08:10
 */
public class LoginDTO {
    private User user;
    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
