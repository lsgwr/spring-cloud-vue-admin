/***********************************************************
 * @Description : 测试接口
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 0:00
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public Object hello() {
        return "hello world";
    }
}
