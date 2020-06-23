package com.example.demoormcustomer.repository;


import com.example.demoormcustomer.models.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
}
