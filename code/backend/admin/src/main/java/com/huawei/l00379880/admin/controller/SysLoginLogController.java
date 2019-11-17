/***********************************************************
 * @Description : 
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 21:56
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.controller;

import com.huawei.l00379880.admin.model.SysLoginLog;
import com.huawei.l00379880.admin.service.SysLoginLogService;
import com.huawei.l00379880.core.http.HttpResult;
import com.huawei.l00379880.core.page.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("loginlog")
@Api(tags = "登录日志接口")
public class SysLoginLogController {
    @Autowired
    private SysLoginLogService sysLoginLogService;

    @PostMapping("/findPage")
    @ApiOperation("获取所有登录日志并进行分页")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLoginLogService.findPage(pageRequest));
    }

    @PostMapping("/delete")
    @ApiOperation("删除登录日志")
    public HttpResult delete(@RequestBody List<SysLoginLog> records) {
        return HttpResult.ok(sysLoginLogService.delete(records));
    }
}
