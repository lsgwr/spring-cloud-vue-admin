/***********************************************************
 * @Description : 配置接口
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 20:09
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.service;

import com.huawei.l00379880.admin.model.SysConfig;
import com.huawei.l00379880.core.service.CurdService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SysConfigService extends CurdService<SysConfig> {
    List<SysConfig> findByLabel(String label);
}
