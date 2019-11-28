package com.huawei.l00379880.admin.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * sys_login_log
 *
 * @author liangshanguang
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class SysLoginLog extends BaseModel {

    public static final String STATUS_LOGIN = "login";
    public static final String STATUS_LOGOUT = "logout";
    public static final String STATUS_ONLINE = "online";

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录状态:online在线，登录初始状态，方便统计在线人数;login：退出登录后将online置为login；logout:退出登录
     */
    private String status;

    /**
     * ip地址
     */
    private String ip;
}