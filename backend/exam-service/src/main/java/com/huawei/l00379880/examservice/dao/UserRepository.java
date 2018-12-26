/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/12/26 07:56
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.examservice.dao;

import com.huawei.l00379880.examservice.entity.exam.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
