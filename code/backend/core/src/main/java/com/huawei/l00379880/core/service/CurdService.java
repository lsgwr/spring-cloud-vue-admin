/***********************************************************
 * @Description : 封装基础的增删改查服务的接口
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 12:40
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.core.service;

import com.huawei.l00379880.core.page.PageRequest;
import com.huawei.l00379880.core.page.PageResult;

import java.util.List;

public interface CurdService<T> {
    /**
     * 保存记录
     *
     * @param record 要保存到数据库的记录对象
     * @return 操作返回码
     */
    int save(T record);

    /**
     * 删除指定的记录
     *
     * @param record 要删除的记录对象
     * @return 操作返回码
     */
    int delete(T record);

    /**
     * 批量删除记录
     *
     * @param records 要删除的记录列表
     * @return 操作返回码
     */
    int delete(List<T> records);

    /**
     * 根据id查询指定的记录
     *
     * @param id 记录的id
     * @return 记录对象
     */
    T findById(Long id);

    /**
     * 分页查询，这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象，
     * <p>
     * 如MyBatis或JPA的分页对象从而避免因替换ORM框架导致服务层、控制层的分页接
     * <p>
     * 口也需要变动的情况，替换ORM框架也不会影响服务层，所以这个分页接口起到了解耦的作用
     *
     * @param pageRequest 自己定义的统一分页查询请求
     * @return PageResult 自己定义的统一分页查询结果
     */
    PageResult findPage(PageRequest pageRequest);
}
