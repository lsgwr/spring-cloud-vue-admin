/***********************************************************
 * @Description : 用户管理的对外REST接口
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 1:53
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.controller;

import com.huawei.l00379880.admin.constant.SysConstants;
import com.huawei.l00379880.admin.model.SysUser;
import com.huawei.l00379880.admin.security.SecurityUtils;
import com.huawei.l00379880.admin.service.SysUserService;
import com.huawei.l00379880.common.utils.FileUtils;
import com.huawei.l00379880.common.utils.PasswordUtils;
import com.huawei.l00379880.core.http.HttpResult;
import com.huawei.l00379880.core.page.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理接口")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/all")
    @ApiOperation("获取所有用户的信息")
    @PreAuthorize("hasAuthority('sys:user:view')")
    public Object findAll() {
        return sysUserService.findAll();
    }

    @PostMapping("/save")
    @ApiOperation("新建或更新用户")
    @PreAuthorize("hasAuthority('sys:user:add') AND hasAuthority('sys:user:edit')")
    public HttpResult save(@RequestBody SysUser record) {
        SysUser user = sysUserService.findById(record.getId());
        if (user != null) {
            if (SysConstants.ADMIN.equalsIgnoreCase(user.getName())) {
                return HttpResult.error("超级管理员不允许修改");
            }
        }
        if (record.getPassword() != null) {
            String salt = PasswordUtils.getSalt();
            if (user == null) {
                // 新增用户
                if (sysUserService.findByName(record.getName()) != null) {
                    return HttpResult.error("用户名已经存在！");
                }
                String password = PasswordUtils.encode(record.getPassword(), salt);
                record.setSalt(salt);
                record.setPassword(password);
            } else {
                // 用户存在，修改用户，且修改密码
                if (!record.getPassword().equals(user.getPassword())) {
                    String password = PasswordUtils.encode(record.getPassword(), salt);
                    record.setSalt(salt);
                    record.setPassword(password);
                }
            }
        }
        return HttpResult.ok(sysUserService.save(record));
    }

    @PostMapping("/delete")
    @ApiOperation("删除用户列表")
    @PreAuthorize("hasAuthority('sys:user:delete')")
    public HttpResult delete(@RequestBody List<SysUser> records) {
        for (SysUser record : records) {
            SysUser sysUser = sysUserService.findById(record.getId());
            if (sysUser != null && SysConstants.ADMIN.equalsIgnoreCase(sysUser.getName())) {
                return HttpResult.error("超级管理员不允许删除!");
            }
        }
        return HttpResult.ok(sysUserService.delete(records));
    }

    @GetMapping("/findByName")
    @ApiOperation("根据用户名获取用户信息")
    @PreAuthorize("hasAuthority('sys:user:view')")
    public HttpResult findByName(@RequestParam String name) {
        return HttpResult.ok(sysUserService.findByName(name));
    }

    @GetMapping("/findPermissions")
    @ApiOperation("根据用户名获取用户权限")
    @PreAuthorize("hasAuthority('sys:user:view')")
    public HttpResult findPermissions(@RequestParam String name) {
        return HttpResult.ok(sysUserService.findPermissions(name));
    }

    @GetMapping("/findUserRoles")
    @ApiOperation("根据用户id获取用户角色")
    public HttpResult findUserRoles(@RequestParam Long userId) {
        return HttpResult.ok(sysUserService.findUserRoles(userId));
    }

    @PostMapping("/exportExcelUser")
    @ApiOperation("导出用户列表到Excel中")
    @PreAuthorize("hasAuthority('sys:user:view')")
    public void exportExcelUser(@RequestBody PageRequest pageRequest, HttpServletResponse res) {
        File file = sysUserService.createUserExcelFile(pageRequest);
        FileUtils.downloadFile(res, file, file.getName());
    }

    @PostMapping("/findPage")
    @ApiOperation("获取分页信息")
    @PreAuthorize("hasAuthority('sys:user:view')")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysUserService.findPage(pageRequest));
    }

    @PreAuthorize("hasAuthority('sys:user:edit')")
    @GetMapping(value="/updatePassword")
    public HttpResult updatePassword(@RequestParam String password, @RequestParam String newPassword) {
        SysUser user = sysUserService.findByName(SecurityUtils.getUsername());
        if(user == null) {
            HttpResult.error("用户不存在!");
        }
        if(SysConstants.ADMIN.equalsIgnoreCase(user.getName())) {
            return HttpResult.error("超级管理员不允许修改!");
        }
        if(!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
            return HttpResult.error("原密码不正确!");
        }
        user.setPassword(PasswordUtils.encode(newPassword, user.getSalt()));
        return HttpResult.ok(sysUserService.save(user));
    }
}
