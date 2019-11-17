/***********************************************************
 * @Description : UserDetailsService接口用于返回用户相关数据。它有loadUserByUsername()方法，根据username查询用户实体，
 * 可以实现该接口覆盖该方法，实现自定义获取用户过程。该接口实现类被DaoAuthenticationProvider 类使用，用于认证过程中载入用户信息
 *
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/18 0:54
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.security;

import com.huawei.l00379880.admin.model.SysUser;
import com.huawei.l00379880.admin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserService.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在！");
        }
        // 用户权限列表，根据权限标识如@PreAuthorize("hasAuthority('sys:menu:view')")标注的接口对比，决定是否可以调用接口
        Set<String> permissions = sysUserService.findPermissions(user.getName());
        List<GrantedAuthority> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());
        return new JwtUserDetails(user.getName(), user.getPassword(), user.getSalt(), grantedAuthorities);
    }
}
