package com.example.blog_sv.service;

import com.example.blog_sv.model.BlogSV;

import java.util.List;

public interface BlogService {
    List<BlogSV> getAllBlogSvs();

    BlogSV getBlogSvById(Long id);

    void deleteBlogSvById(Long id);

    void saveBlogSv(BlogSV blogSV);

    void updateBlogSv(Long id, BlogSV blogSV);
}
