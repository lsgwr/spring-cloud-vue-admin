/***********************************************************
 * @Description : 最终的试卷，添加了考试分数
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/12/24 22:34
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
public class Paper {
    /**
     * 数据库主键
     */
    @Id
    @GeneratedValue
    private Long id;
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
