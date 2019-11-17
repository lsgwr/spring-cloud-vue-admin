package com.huawei.l00379880.admin.mapper;

import com.huawei.l00379880.admin.model.SysLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysLogMapper继承基类
 *
 * @author liangshanguang
 */
@Repository
public interface SysLogMapper extends MyBatisBaseDao<SysLog, Long> {
    /**
     * 获取所有的的系统日志
     *
     * @return 所有数据的分页对象
     */
    List<SysLog> findPage();

    /**
     * 根据用户名进行模糊查询
     *
     * @param userName 用户名，不必是完整的用户名
     * @return 符合条件的日志组成的对象
     */
    List<SysLog> findPageByUserName(@Param("userName") String userName);
}