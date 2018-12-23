/***********************************************************
 * @Description : 角色实体类
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/12/4 00:23
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.uaaservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
