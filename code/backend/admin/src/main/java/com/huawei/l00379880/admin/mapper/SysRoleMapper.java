package com.huawei.l00379880.admin.mapper;

import com.huawei.l00379880.admin.model.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysRoleMapper继承基类
 *
 * @author liangshanguang
 */
@Repository
public interface SysRoleMapper extends MyBatisBaseDao<SysRole, Long> {
    /**
     * 获取所有角色，结果分页
     *
     * @return 分页结果
     */
    List<SysRole> findPage();

    /**
     * 获取所有的角色，不分页
     *
     * @return 角色列表
     */
    List<SysRole> findAll();

    /**
     * 根据角色名获取角色列表，name支持模糊搜索
     *
     * @param name 角色名，可以不输全
     * @return 角色列表，分页了
     */
    List<SysRole> findPageByName(@Param(value = "name") String name);

    /**
     * 根据完整的角色名获取角色列表
     *
     * @param name 角色名，必须完整
     * @return 角色列表，不分页
     */
    List<SysRole> findByName(@Param(value = "name") String name);
}