package com.huawei.l00379880.admin.mapper;

import com.huawei.l00379880.admin.model.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysMenuMapper继承基类
 *
 * @author liangshanguang
 */
@Repository
public interface SysMenuMapper extends MyBatisBaseDao<SysMenu, Long> {
    List<SysMenu> findPage();

    List<SysMenu> findPageByName(@Param("name") String name);

    List<SysMenu> findAll();

    List<SysMenu> findByUserName(@Param("userName") String userName);

    List<SysMenu> findRoleMenus(@Param("roleId") Long roleId);
}