/***********************************************************
 * @Description : 系统自带地用户接口实现
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/12/5 00:14
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.uaaservice.service.impl;

import com.huawei.l00379880.uaaservice.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
