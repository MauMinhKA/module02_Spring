package com.example.product_manager.services;

import com.example.product_manager.models.Product;
import com.example.product_manager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public void deleteProductById(int id) {
        productRepository.DeleteById(id);
    }

    @Override
    public void saveProduct(Product t) {
        productRepository.save(t);
    }

    @Override
    public void updateProduct(int id, Product t) {
        productRepository.update(id, t);
    }
}
