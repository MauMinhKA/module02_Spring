package com.example.customermanager.services;

import com.example.customermanager.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    void deleteProductById(Long id);

    void saveProduct(Product t);

    void updateProduct(Long id, Product t);
}
