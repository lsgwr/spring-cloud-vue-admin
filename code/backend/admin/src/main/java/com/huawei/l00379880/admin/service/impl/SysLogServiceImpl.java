/***********************************************************
 * @Description : 系统日志接口的实现类
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 21:33
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.service.impl;

import com.huawei.l00379880.admin.mapper.SysLogMapper;
import com.huawei.l00379880.admin.model.SysLog;
import com.huawei.l00379880.admin.service.SysLogService;
import com.huawei.l00379880.core.page.MyBatisPageHelper;
import com.huawei.l00379880.core.page.PageRequest;
import com.huawei.l00379880.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int save(SysLog record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysLogMapper.insertSelective(record);
        }
        return sysLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysLog record) {
        return sysLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysLog> records) {
        for (SysLog record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysLog findById(Long id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParamValue("userName");
        if (label != null) {
            return MyBatisPageHelper.findPage(pageRequest, sysLogMapper, "findPageByUserName", label);
        }
        return MyBatisPageHelper.findPage(pageRequest, sysLogMapper);
    }
}
