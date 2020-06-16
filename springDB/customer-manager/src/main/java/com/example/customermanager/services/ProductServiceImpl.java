package com.example.customermanager.services;

import com.example.customermanager.models.Product;
import com.example.customermanager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Product getProductById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.DeleteById(id);
    }

    @Override
    public void saveProduct(Product t) {
        productRepository.save(t);
    }

    @Override
    public void updateProduct(Long id, Product t) {
        productRepository.update(id, t);
    }
}
