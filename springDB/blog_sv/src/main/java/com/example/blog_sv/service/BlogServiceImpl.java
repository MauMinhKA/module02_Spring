package com.example.blog_sv.service;

import com.example.blog_sv.model.BlogSV;
import com.example.blog_sv.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<BlogSV> getAllBlogSvs() {
        return blogRepository.getAll();
    }

    @Override
    public BlogSV getBlogSvById(Long id) {
        return blogRepository.getById(id);
    }

    @Override
    public void deleteBlogSvById(Long id) {
        blogRepository.DeleteById(id);
    }

    @Override
    public void saveBlogSv(BlogSV blogSV) {
        blogRepository.Save(blogSV);
    }

    @Override
    public void updateBlogSv(Long id, BlogSV blogSV) {
        blogRepository.update(id, blogSV);
    }


}
