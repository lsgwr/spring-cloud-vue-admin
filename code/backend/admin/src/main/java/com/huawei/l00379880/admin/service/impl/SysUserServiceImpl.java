/***********************************************************
 * @Description : 用户服务的接口实现
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 1:52
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.service.impl;

import com.huawei.l00379880.admin.mapper.SysUserMapper;
import com.huawei.l00379880.admin.model.SysUser;
import com.huawei.l00379880.admin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }
}
