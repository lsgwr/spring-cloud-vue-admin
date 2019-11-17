package com.huawei.l00379880.admin.mapper;

import com.huawei.l00379880.admin.model.SysUser;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 拿到分页对象
     *
     * @return 数据列表
     */
    List<SysUser> findPage();

    /**
     * 根据用户名查询用户
     *
     * @param name 用户名
     * @return 找到的用户
     */
    SysUser findByName(@Param(value = "name") String name);

    /**
     * 根据用户名(模糊搜索)获取用户列表的分页对象
     *
     * @param name 用户名
     * @return 分页对象
     */
    List<SysUser> findPageByName(@Param(value = "name") String name);

    /**
     * 根据用户名(模糊搜索)和邮箱(模糊搜索)获取分页对象
     *
     * @param name  用户名
     * @param email 邮箱
     * @return 分页对象
     */
    List<SysUser> findPageByNameAndEmail(@Param(value = "name") String name, @Param(value = "email") String email);
}