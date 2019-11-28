/***********************************************************
 * @Description : 用户登录日志接口
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 21:49
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.service;

import com.huawei.l00379880.admin.model.SysLoginLog;
import com.huawei.l00379880.core.service.CurdService;

public interface SysLoginLogService extends CurdService<SysLoginLog> {
    /**
     * 记录登录日志
     *
     * @param username 登录用户名
     * @param ipAddr   登录者的ip
     * @return 执行成功与否的错误码
     */
    int writeLoginLog(String username, String ipAddr);
}
