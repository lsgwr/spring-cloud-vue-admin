package com.huawei.l00379880.admin.mapper;

import com.huawei.l00379880.admin.model.SysLoginLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysLoginLogMapper继承基类
 *
 * @author liangshanguang
 */
@Repository
public interface SysLoginLogMapper extends MyBatisBaseDao<SysLoginLog, Long> {
    /**
     * 获取所有登录日志
     *
     * @return 登录日志分页列表
     */
    List<SysLoginLog> findPage();

    /**
     * 根据用户名进行模糊查询获得登录日志
     *
     * @param userName 用户名，不必写全
     * @return 日志分页列表
     */
    List<SysLoginLog> findPageByUserName(@Param("userName") String userName);

    /**
     * 根据登录状态筛选登录日志
     *
     * @param status 登录状态
     * @return 登录日志的分页列表
     */
    List<SysLoginLog> findPageByStatus(@Param("status") String status);

    /**
     * 根据用户名和和状态得到用户登录日志列表
     *
     * @param userName 用户名
     * @param status   账号状态
     * @return 登录日志
     */
    List<SysLoginLog> findByUserNameAndStatus(@Param("userName") String userName, @Param("status") String status);

    /**
     * 根据用户名和和状态得到用户登录分页日志列表
     *
     * @param userName 用户名
     * @param status   账号状态
     * @return 登录日志
     */
    List<SysLoginLog> findPageByUserNameAndStatus(@Param(value = "userName") String userName, @Param(value = "status") String status);
}