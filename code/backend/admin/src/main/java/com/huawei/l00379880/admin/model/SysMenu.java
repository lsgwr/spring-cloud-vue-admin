package com.huawei.l00379880.admin.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * sys_menu
 *
 * @author liangshanguang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysMenu extends BaseModel {
    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父菜单id,一级菜单id为0
     */
    private Long parentId;

    /**
     * 菜单URL,类型有：1.普通vue路由入/sys/user;2.嵌套完整外部页面以http(s)开头的链接;3.嵌套服务器页面，使用iframe,用ifram://实际url的形式，在使用时会进行替换
     */
    private String url;

    /**
     * 授权，多个用逗号分隔，入sys:user:add,sys:user:edit
     */
    private String perms;

    /**
     * 类型:0目录;1菜单;2按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 是否删除：-1已删除;0正常
     */
    private Byte delFlag;

    /**
     * 非数据库字段:父菜单的名字
     */
    private String parentName;
    /**
     * 非数据库字段：菜单层级
     */
    private Integer level;
    /**
     * 非数据库字段：当前菜单的所有字菜单
     */
    private List<SysMenu> children;
}