package com.huawei.l00379880.examservice.dto;


import com.huawei.l00379880.examservice.entity.Blog;
import com.huawei.l00379880.examservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by liangshanguang at 2018-12-23 21：29
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDetailDTO {
    private Blog blog;
    private User user;
}
