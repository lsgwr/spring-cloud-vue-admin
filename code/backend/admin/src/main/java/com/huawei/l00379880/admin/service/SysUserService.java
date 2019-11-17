/***********************************************************
 * @Description : 用户服务实现
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 1:51
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.service;

import com.huawei.l00379880.admin.model.SysUser;
import com.huawei.l00379880.core.service.CurdService;

import java.util.List;

public interface SysUserService extends CurdService<SysUser> {
    List<SysUser> findAll();
}
