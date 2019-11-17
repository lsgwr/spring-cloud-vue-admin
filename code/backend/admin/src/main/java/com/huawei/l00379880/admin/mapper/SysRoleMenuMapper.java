package com.huawei.l00379880.admin.mapper;

import com.huawei.l00379880.admin.model.SysRoleMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysRoleMenuMapper继承基类
 *
 * @author liangshanguang
 */
@Repository
public interface SysRoleMenuMapper extends MyBatisBaseDao<SysRoleMenu, Long> {
    /**
     * 获取指定角色可访问的菜单列表
     *
     * @param roleId 角色id
     * @return 菜单列表
     */
    List<SysRoleMenu> findRoleMenus(@Param("roleId") Long roleId);

    /**
     * 获取所有的菜单列表
     *
     * @return 菜单列表
     */
    List<SysRoleMenu> findAll();

    /**
     * 删除角色
     *
     * @param roleId 角色id
     * @return 操作返回码
     */
    int deleteByRoleId(@Param("roleId") Long roleId);
}