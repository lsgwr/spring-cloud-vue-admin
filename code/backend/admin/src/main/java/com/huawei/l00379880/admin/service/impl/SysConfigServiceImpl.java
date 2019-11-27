/***********************************************************
 * @Description : 配置接口的实现
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 20:11
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.service.impl;

import com.huawei.l00379880.admin.mapper.SysConfigMapper;
import com.huawei.l00379880.admin.model.SysConfig;
import com.huawei.l00379880.admin.service.SysConfigService;
import com.huawei.l00379880.core.page.MyBatisPageHelper;
import com.huawei.l00379880.core.page.PageRequest;
import com.huawei.l00379880.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    @Override
    public List<SysConfig> findByLabel(String label) {
        return sysConfigMapper.findByLabel(label);
    }

    @Override
    public int save(SysConfig record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysConfigMapper.insertSelective(record);
        }
        return sysConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysConfig record) {
        return sysConfigMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysConfig> records) {
        for (SysConfig record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysConfig findById(Long id) {
        return sysConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParamValue("label");
        if (label != null) {
            return MyBatisPageHelper.findPage(pageRequest, sysConfigMapper, "findPageByLabel", label);
        }
        return MyBatisPageHelper.findPage(pageRequest, sysConfigMapper);
    }
}
