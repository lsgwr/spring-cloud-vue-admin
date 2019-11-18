/***********************************************************
 * @Description : 菜单管理接口
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 20:50
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.controller;

import com.huawei.l00379880.admin.model.SysMenu;
import com.huawei.l00379880.admin.service.SysMenuService;
import com.huawei.l00379880.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@Api(tags = "菜单管理接口")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @PostMapping("/save")
    @ApiOperation("保存菜单")
    @PreAuthorize("hasAuthority('sys:menu:add') AND hasAuthority('sys:menu:edit')")
    public HttpResult save(@RequestBody SysMenu record) {
        return HttpResult.ok(sysMenuService.save(record));
    }

    @PostMapping("/delete")
    @ApiOperation("删除菜单")
    @PreAuthorize("hasAuthority('sys:menu:delete')")
    public HttpResult delete(@RequestBody List<SysMenu> records) {
        return HttpResult.ok(sysMenuService.delete(records));
    }

    @GetMapping("/findNavTree")
    @ApiOperation("获取当前用户的导航树")
    @PreAuthorize("hasAuthority('sys:menu:view')")
    public HttpResult findNavTree(@RequestParam String userName) {
        return HttpResult.ok(sysMenuService.findTree(userName, 1));
    }

    @GetMapping("/findMenuTree")
    @ApiOperation("获取菜单树")
    @PreAuthorize("hasAuthority('sys:menu:view')")
    public HttpResult findMenuTree() {
        return HttpResult.ok(sysMenuService.findTree(null, 0));
    }
}

