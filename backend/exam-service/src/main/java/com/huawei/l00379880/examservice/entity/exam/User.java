/***********************************************************
 * @Description : 考试系统的用户实体类
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/12/24 21:16
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.examservice.entity.exam;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 数据库主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 用户名，这里不用存密码，因为sys_user中的user表已经把密码存好了
     */
    @Column(nullable = false, unique = true)
    private String username;
    /**
     * 用户邮箱，不是必须的，可以在后序补全
     */
    private String email;
    /**
     * 性别，男/女
     */
    private String gender;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
