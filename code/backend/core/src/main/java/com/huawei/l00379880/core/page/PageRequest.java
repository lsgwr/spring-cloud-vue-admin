/***********************************************************
 * @Description : 分页请求对象
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 12:48
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.core.page;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum;

    /**
     * 每页数量
     */
    private int pageSize;

    /**
     * 查询参数
     */
    private List<Param> params = new ArrayList<>();

    /**
     * 查询参数对象
     *
     * @param name Param的value
     * @return 指定的键值对对象
     */
    public Param getParam(String name) {
        for (Param param : this.params) {
            if (name != null && name.equals(param.getName())) {
                return param;
            }
        }
        return null;
    }

    /**
     * 查询参数值
     *
     * @param name 参数名称
     * @return 参数值
     */
    public String getParamValue(String name) {
        Param param = getParam(name);
        if (param != null) {
            return param.getValue();
        }
        return null;
    }
}
