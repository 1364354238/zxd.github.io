package com.example.dao;

import com.example.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author dzx
 * @data 2021/11/5 -9:47
 */
public interface BlogMapper {
    void insertBlog(Blog blog);

    List<Blog> queryBlogIF(Map map);
    List<Blog> queryBlogChoose(Map map);

    void updateBlog(Map map);
    List<Blog> queryBlogIn(Map map);
}
