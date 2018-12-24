/***********************************************************
 * @Description : 题目的选项
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/12/24 22:31
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
public class Option {
    /**
     * 数据库主键
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 选项
     */
    private String desc;
    /**
     * 选项所属题目的类型:单选(option)、多选(check)、判断(judge)
     */
    private String type;
    /**
     * 问题的ID
     */
    private Long questionId;
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
