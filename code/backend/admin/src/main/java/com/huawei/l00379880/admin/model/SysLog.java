package com.huawei.l00379880.admin.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * sys_log
 *
 * @author liangshanguang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysLog extends BaseModel {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户操作
     */
    private String operation;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 执行时长(毫秒)
     */
    private Long time;

    /**
     * ip地址
     */
    private String ip;
}