package com.huawei.l00379880.admin.mapper;

import com.huawei.l00379880.admin.model.SysUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysUserRoleMapper继承基类
 *
 * @author liangshanguang
 */
@Repository
public interface SysUserRoleMapper extends MyBatisBaseDao<SysUserRole, Long> {

    List<SysUserRole> findUserRoles(@Param("userId") Long userId);

    int deleteByUserId(@Param("userId") Long userId);
}