/***********************************************************
 * @Description : 系统日志对外接口
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 21:36
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.controller;

import com.huawei.l00379880.admin.model.SysLog;
import com.huawei.l00379880.admin.service.SysLogService;
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
@RequestMapping("/log")
@Api(tags = "系统日志管理接口")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @PostMapping("/findPage")
    @ApiOperation("获取系统日志的分页列表")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLogService.findPage(pageRequest));
    }

    @PostMapping("/delete")
    @ApiOperation("删除系统日志")
    public HttpResult delete(@RequestBody List<SysLog> records) {
        return HttpResult.ok(sysLogService.delete(records));
    }
}