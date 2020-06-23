package com.example.demoormcustomer.services;

import com.example.demoormcustomer.models.Customer;
import com.example.demoormcustomer.models.Province;

import java.util.Optional;

public interface CustomerService {
    Iterable<Customer> findAll() ;
    Customer findById(Long id) ;
    void save(Customer customer) ;
    void delete(Long id) ;
    Iterable<Customer> findAllByProvince(Province province);
//    void updateProduct(Long id, Customer customer);
}
