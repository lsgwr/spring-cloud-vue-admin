/***********************************************************
 * @Description : 部门管理接口
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 21:17
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.controller;

import com.huawei.l00379880.admin.model.SysDept;
import com.huawei.l00379880.admin.service.SysDeptService;
import com.huawei.l00379880.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
@Api(tags = "部门管理接口")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @PostMapping("/save")
    @ApiOperation("保存部门信息")
    @PreAuthorize("hasAuthority('sys:dept:add') AND hasAuthority('sys:dept:edit')")
    public HttpResult save(@RequestBody SysDept record) {
        return HttpResult.ok(sysDeptService.save(record));
    }

    @PostMapping("/delete")
    @ApiOperation("删除部门信息")
    @PreAuthorize("hasAuthority('sys:dept:delete')")
    public HttpResult delete(@RequestBody List<SysDept> records) {
        return HttpResult.ok(sysDeptService.delete(records));
    }

    @GetMapping("/findTree")
    @ApiOperation("获取部门树")
    @PreAuthorize("hasAuthority('sys:dept:view')")
    public HttpResult findTree() {
        return HttpResult.ok(sysDeptService.findTree());
    }

}
