/***********************************************************
 * @Description : 分页请求对象
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 12:48
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.core.page;

import java.util.HashMap;
import java.util.Map;

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
    private Map<String, Object> params = new HashMap<>();

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    /**
     * 根据键拿到请求参数的指定键值对
     *
     * @param key map的key
     * @return 指定键的值
     */
    public Object getParam(String key) {
        return params.get(key);
    }
}
