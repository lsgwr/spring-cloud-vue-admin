package com.huawei.l00379880.admin.mapper;

import com.huawei.l00379880.admin.model.SysDict;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysDictMapper继承基类
 */
@Repository
public interface SysDictMapper extends MyBatisBaseDao<SysDict, Long> {
    /**
     * 分页查询
     *
     * @return 分页对象
     */
    List<SysDict> findPage();

    /**
     * 根据标签名进行查询
     *
     * @param label 标签名
     * @return 数据列表
     */
    List<SysDict> findByLabel(@Param(value = "label") String label);

    /**
     * 根据标签名进行分页查询
     *
     * @param label 标签名
     * @return 分页对象
     */
    List<SysDict> findPageByLabel(@Param(value = "label") String label);
}