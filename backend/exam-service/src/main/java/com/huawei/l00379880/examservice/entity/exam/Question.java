/***********************************************************
 * @Description : 题目
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/12/24 22:27
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
public class Question {
    /**
     * 数据库主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 题干
     */
    private String description;
    /**
     * 题目的类型:单选(option)、多选(check)、判断(judge)
     */
    private String type;
    /**
     * 答案的ID，多选时ID用分号隔开
     */
    private String answer;
    /**
     * 题目的分析
     */
    private String analysis;
    /**
     * 试题难度：简单(low)、中等(middle)、复杂(high)
     */
    private String difficulty;
    /**
     * 用户的id,这里指创建人
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
