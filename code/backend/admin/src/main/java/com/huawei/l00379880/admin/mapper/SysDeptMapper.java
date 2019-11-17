package com.huawei.l00379880.admin.mapper;

import com.huawei.l00379880.admin.model.SysDept;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysDeptMapper继承基类
 *
 * @author liangshanguang
 */
@Repository
public interface SysDeptMapper extends MyBatisBaseDao<SysDept, Long> {
    /**
     * 获取机构的分页信息
     *
     * @return 结构分页信息
     */
    List<SysDept> findPage();

    /**
     * 获取所有的机构信息
     *
     * @return 所有的结构信息
     */
    List<SysDept> findAll();
}