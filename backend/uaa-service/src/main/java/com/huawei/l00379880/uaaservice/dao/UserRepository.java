/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/12/4 00:31
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.uaaservice.dao;

import com.huawei.l00379880.uaaservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据用户名获取用户，因为实体类User配置了username为unique，所以只会返回1个用户
     */
    User findByUsername(String username);
}