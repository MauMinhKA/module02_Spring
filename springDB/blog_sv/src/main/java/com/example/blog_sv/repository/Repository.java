package com.example.blog_sv.repository;

import com.example.blog_sv.model.BlogSV;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();
    T getById(Long id);
    void DeleteById(Long id);
    void Save(T t);
    void update(Long id, BlogSV blogSV);
}
