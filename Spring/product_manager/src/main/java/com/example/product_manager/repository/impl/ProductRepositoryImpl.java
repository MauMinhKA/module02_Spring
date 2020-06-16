package com.example.product_manager.repository.impl;

import com.example.product_manager.models.Product;
import com.example.product_manager.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static Map<Integer, Product> listProducts;

    static {
        listProducts = new HashMap<>();
        listProducts.put(1, new Product((int) (Math.random() * 100), "IphoneXs", 899, "bảo hành 1 năm", "fullbox", "apple"));
        listProducts.put(2, new Product((int) (Math.random() * 100), "IphoneXs Max", 999, "bảo hành 1 năm", "fullbox", "apple"));
        listProducts.put(3, new Product((int) (Math.random() * 100), "Samsung s10", 999, "bảo hành 1 năm", "fullbox", "Samsung"));
        listProducts.put(4, new Product((int) (Math.random() * 100), "iphone 7Plus", 699, "bảo hành 1 năm", "fullbox", "apple"));
        listProducts.put(5, new Product((int) (Math.random() * 100), "Iphone 7s", 599, "bảo hành 1 năm", "fullbox", "apple"));
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(listProducts.values());
    }

    @Override
    public Product getById(int id) {
        return listProducts.get(id);
    }

    @Override
    public void DeleteById(int id) {
        listProducts.remove(id);
    }

    @Override
    public void save(Product product) {
        listProducts.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        listProducts.put(id, product);
    }
}
