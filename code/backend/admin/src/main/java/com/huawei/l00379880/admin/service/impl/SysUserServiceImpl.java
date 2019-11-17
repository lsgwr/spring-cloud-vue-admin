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
import com.huawei.l00379880.core.page.MyBatisPageHelper;
import com.huawei.l00379880.core.page.PageRequest;
import com.huawei.l00379880.core.page.PageResult;
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

    @Override
    public int save(SysUser record) {
        return 0;
    }

    @Override
    public int delete(SysUser record) {
        return 0;
    }

    @Override
    public int delete(List<SysUser> records) {
        return 0;
    }

    @Override
    public SysUser findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MyBatisPageHelper.findPage(pageRequest, sysUserMapper);
    }
}
