package com.huawei.l00379880.examservice.service;


import com.huawei.l00379880.examservice.dto.BlogDetailDTO;
import com.huawei.l00379880.examservice.entity.Blog;

import java.util.List;

/**
 * Created by liangshanguang at 2018-12-23 21：29
 */
public interface BlogService {


    public Blog postBlog(Blog blog);

    public List<Blog> findBlogs(String username);


    public BlogDetailDTO findBlogDetail(Long id);

}
