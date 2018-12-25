/***********************************************************
 * @Description : 考试
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/12/24 22:26
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
public class Exam {
    /**
     * 数据库主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 考试名称
     */
    private String title;
    /**
     * 考试的说明
     */
    private String description;
    /**
     * 考试类型(自己定义的字符串)
     */
    private String type;
    /**
     * 有效期开始
     */
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /**
     * 有效期结束
     */
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    /**
     * 考试时间限制,分钟
     */
    private Integer timeLimit;
    /**
     * 及格分数
     */
    private Integer passScore;
    /**
     * 创建用户的ID
     */
    private Long userId;
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
