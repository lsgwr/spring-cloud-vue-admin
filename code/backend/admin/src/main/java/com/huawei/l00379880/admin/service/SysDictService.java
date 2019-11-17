/***********************************************************
 * @Description : 字典管理接口
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 16:31
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.service;

import com.huawei.l00379880.admin.model.SysDict;
import com.huawei.l00379880.core.service.CurdService;

import java.util.List;

public interface SysDictService extends CurdService<SysDict> {
    /**
     * 根据label名进行查询
     *
     * @param label 标签名
     * @return 字典对象列表
     */
    List<SysDict> findByLabel(String label);
}
