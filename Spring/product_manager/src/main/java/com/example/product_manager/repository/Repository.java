package com.example.product_manager.repository;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();
    T getById(int id);
    void DeleteById(int id);
    void  save(T t);
    void update(int id,T t);

}
