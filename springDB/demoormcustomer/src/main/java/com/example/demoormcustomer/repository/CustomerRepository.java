package com.example.demoormcustomer.repository;


import com.example.demoormcustomer.models.Customer;
import com.example.demoormcustomer.models.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Iterable<Customer> findAllByProvince(Province province);
//    void updateProduct(Long id, Customer customer);
}
