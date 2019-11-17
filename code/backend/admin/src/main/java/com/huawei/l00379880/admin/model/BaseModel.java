/***********************************************************
 * @Description : 各个表都有的字段
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 17:47
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.model;

import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {
    /**
     * 编号
     */
    private Long id;
    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String lastUpdateBy;

    /**
     * 更新时间
     */
    private Date lastUpdateTime;
}
