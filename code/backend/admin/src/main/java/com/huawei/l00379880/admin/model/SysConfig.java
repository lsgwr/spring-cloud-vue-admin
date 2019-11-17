package com.huawei.l00379880.admin.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * sys_config
 *
 * @author liangshanguang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysConfig extends BaseModel {
    /**
     * 数据值
     */
    private String value;

    /**
     * 标签名
     */
    private String label;

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序(升序)
     */
    private Long sort;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 是否删除：-1已删除;0正常
     */
    private Byte delFlag;
}