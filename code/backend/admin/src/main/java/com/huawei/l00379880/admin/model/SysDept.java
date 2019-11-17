package com.huawei.l00379880.admin.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * sys_dept
 *
 * @author liangshanguang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDept extends BaseModel {
    /**
     * 机构名称
     */
    private String name;

    /**
     * 上级机构id,一级机构id为0
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 是否删除：-1已删除;0正常
     */
    private Byte delFlag;

    /**
     * 非数据库字段:该部门的字部门
     */
    private List<SysDept> children;
    /**
     * 非数据库字段：上一级部门的名称
     */
    private String parentName;
    /**
     * 非数据库字段：部门的级别
     */
    private Integer level;
}