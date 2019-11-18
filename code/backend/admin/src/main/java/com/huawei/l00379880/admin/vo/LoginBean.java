/***********************************************************
 * @Description : 登录时的传参
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/18 7:58
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.vo;

import lombok.Data;

@Data
public class LoginBean {
    String account;
    String password;
    String captcha;
}
