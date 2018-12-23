package com.huawei.l00379880.examservice.web;

import com.huawei.l00379880.common.annotation.SysLogger;
import com.huawei.l00379880.common.dto.RespDTO;
import com.huawei.l00379880.common.exception.CommonException;
import com.huawei.l00379880.common.exception.ErrorCode;
import com.huawei.l00379880.examservice.entity.Blog;
import com.huawei.l00379880.examservice.service.BlogService;
import com.huawei.l00379880.examservice.util.UserUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by liangshanguang at 2018-12-23 21：29
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @ApiOperation(value = "发布博客", notes = "发布博客")
    @PreAuthorize("hasRole('USER')")
    @PostMapping("")
    @SysLogger("postBlog")
    public RespDTO postBlog(@RequestBody Blog blog) {
        //字段判读省略
        Blog blog1 = blogService.postBlog(blog);
        return RespDTO.onSuc(blog1);
    }

    @ApiOperation(value = "根据用户id获取所有的blog", notes = "根据用户id获取所有的blog")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{username}")
    @SysLogger("getBlogs")
    public RespDTO getBlogs(@PathVariable String username) {
        //字段判读省略
        if (UserUtils.isMyself(username)) {
            List<Blog> blogs = blogService.findBlogs(username);
            return RespDTO.onSuc(blogs);
        } else {
            throw new CommonException(ErrorCode.TOKEN_IS_NOT_MATCH_USER);
        }
    }

    @ApiOperation(value = "获取博文的详细信息", notes = "获取博文的详细信息")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{id}/detail")
    @SysLogger("getBlogDetail")
    public RespDTO getBlogDetail(@PathVariable Long id) {
        return RespDTO.onSuc(blogService.findBlogDetail(id));
    }
}
