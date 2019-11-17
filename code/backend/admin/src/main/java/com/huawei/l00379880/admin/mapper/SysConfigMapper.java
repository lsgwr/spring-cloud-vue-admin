package com.huawei.l00379880.admin.mapper;

import com.huawei.l00379880.admin.model.SysConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysConfigMapper继承基类
 *
 * @author liangshanguang
 */
@Repository
public interface SysConfigMapper extends MyBatisBaseDao<SysConfig, Long> {
    /**
     * 获取系统配置的分页结果
     *
     * @return 系统配置
     */
    List<SysConfig> findPage();

    /**
     * 根据设置名拿到设置对象
     *
     * @param label 设置名
     * @return 设置对象
     */
    List<SysConfig> findByLabel(@Param("label") String label);

    /**
     * 根据设置名拿到设置分页对象
     *
     * @param label 设置名
     * @return 设置对象
     */
    List<SysConfig> findPageByLabel(@Param("label") String label);
}