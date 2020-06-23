package com.example.demoormcustomer.services;

import com.example.demoormcustomer.models.Customer;

import java.util.Optional;

public interface CustomerService {
    Iterable<Customer> findAll() ;
    Customer findById(Long id) ;
    void save(Customer customer) ;
    void delete(Long id) ;
//    void update(Long id ,Customer customer) ;
}
