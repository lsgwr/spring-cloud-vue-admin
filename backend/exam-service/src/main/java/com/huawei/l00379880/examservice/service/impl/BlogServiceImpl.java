/***********************************************************
 * @Description : 博客服务的实现类
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/12/24 08:13
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.examservice.service.impl;

import com.huawei.l00379880.common.dto.RespDTO;
import com.huawei.l00379880.common.exception.CommonException;
import com.huawei.l00379880.common.exception.ErrorCode;
import com.huawei.l00379880.examservice.client.UserServiceClient;
import com.huawei.l00379880.examservice.dao.BlogRepository;
import com.huawei.l00379880.examservice.dto.BlogDetailDTO;
import com.huawei.l00379880.examservice.entity.Blog;
import com.huawei.l00379880.examservice.entity.User;
import com.huawei.l00379880.examservice.service.BlogService;
import com.huawei.l00379880.examservice.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

        @Autowired
        BlogRepository blogRepository;

        @Autowired
        UserServiceClient userServiceClient;

        @Override
        public Blog postBlog(Blog blog) {
            return blogRepository.save(blog);
        }

        @Override
        public List<Blog> findBlogs(String username) {
            return blogRepository.findByUsername(username);
        }


        @Override
        public BlogDetailDTO findBlogDetail(Long id) {
            Blog blog = blogRepository.findOne(id);
            if (null == blog) {
                throw new CommonException(ErrorCode.BLOG_IS_NOT_EXIST);
            }
            RespDTO<User> respDTO = userServiceClient.getUser(UserUtils.getCurrentToken(), blog.getUsername());
            if (respDTO == null) {
                throw new CommonException(ErrorCode.RPC_ERROR);
            }
            BlogDetailDTO blogDetailDTO = new BlogDetailDTO();
            blogDetailDTO.setBlog(blog);
            blogDetailDTO.setUser(respDTO.data);
            return blogDetailDTO;
        }
}
