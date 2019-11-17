/***********************************************************
 * @Description : 部门管理接口
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 21:08
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.service;

import com.huawei.l00379880.admin.model.SysDept;
import com.huawei.l00379880.core.service.CurdService;

import java.util.List;

public interface SysDeptService extends CurdService<SysDept> {
    /**
     * 查询部门树
     *
     * @return 部门树
     */
    List<SysDept> findTree();
}
