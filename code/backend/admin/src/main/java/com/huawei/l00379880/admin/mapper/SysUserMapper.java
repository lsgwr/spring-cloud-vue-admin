package com.huawei.l00379880.admin.mapper;

import com.huawei.l00379880.admin.model.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysUserMapper继承基类
 */
@Repository
public interface SysUserMapper extends MyBatisBaseDao<SysUser, Long> {
    /**
     * 查找所有用户
     *
     * @return 所有用户
     */
    List<SysUser> findAll();
    List<SysUser> findPage();
}