/***********************************************************
 * @Description : 考试的数据接口
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/12/26 07:49
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.examservice.dao;

import com.huawei.l00379880.examservice.entity.exam.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
