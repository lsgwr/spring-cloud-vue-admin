package com.huawei.l00379880.userservice.dao;


import com.huawei.l00379880.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liangshanguang at 2018-12-24 08:10
 */

public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
