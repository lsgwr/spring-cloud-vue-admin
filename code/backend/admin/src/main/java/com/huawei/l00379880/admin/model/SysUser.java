package com.huawei.l00379880.admin.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * sys_user
 *
 * @author liangshanguang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseModel {


    /**
     * 用户名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态: 0禁用;1正常
     */
    private Byte status;

    /**
     * 机构id
     */
    private Long deptId;

    /**
     * 是否删除：-1已删除；0正常
     */
    private Byte delFlag;

    /**
     * 部门名称，非数据库字段，方便前端显示
     */
    private String deptName;
    /**
     * 非数据库字段，角色列表拼接的字符串
     */
    private String roleNames;
    /**
     * 非数据库字段：角色对象列表
     */
    private List<SysUserRole> userRoles = new ArrayList<>();
}