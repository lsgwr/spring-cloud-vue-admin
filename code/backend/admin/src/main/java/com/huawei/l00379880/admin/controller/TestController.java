/***********************************************************
 * @Description : 测试接口
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 0:00
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(tags = "测试用接口集")
public class TestController {
    @GetMapping("/hello")
    @ApiOperation(value = "测试", notes = "最经典的hello world")
    public Object hello() {
        return "hello world";
    }
}
