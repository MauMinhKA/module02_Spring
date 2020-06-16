package com.example.customermanager.repository;

import com.example.customermanager.models.Product;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();
    T getById(Long id);
    void DeleteById(Long id);
    void  save(T t);
    void update(Long id, Product t);

}
