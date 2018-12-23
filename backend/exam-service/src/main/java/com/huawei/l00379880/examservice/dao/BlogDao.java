package com.huawei.l00379880.examservice.dao;

import com.huawei.l00379880.examservice.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by liangshanguang at 2018-12-23 21：29
 */

public interface BlogDao extends JpaRepository<Blog, Long> {

    List<Blog> findByUsername(String username);

}
