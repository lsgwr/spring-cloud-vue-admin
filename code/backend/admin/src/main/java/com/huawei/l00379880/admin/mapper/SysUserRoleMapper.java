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

    /**
     * 获取指定用户的角色列表
     *
     * @param userId 用户id
     * @return 角色列表
     */
    List<SysUserRole> findUserRoles(@Param("userId") Long userId);

    /**
     * 根据用户id删除该用户下的所有角色
     *
     * @param userId 用户id
     * @return 操作返回码
     */
    int deleteByUserId(@Param("userId") Long userId);
}