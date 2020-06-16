package com.example.product_manager.services;

import com.example.product_manager.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(int id);

    void deleteProductById(int id);

    void saveProduct(Product t);

    void updateProduct(int id, Product t);
}
