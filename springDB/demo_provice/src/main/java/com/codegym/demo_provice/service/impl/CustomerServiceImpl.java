package com.codegym.demo_provice.service.impl;

import com.codegym.demo_provice.entity.Customer;
import com.codegym.demo_provice.repository.CustomerRepository;
import com.codegym.demo_provice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAllByIsDeleteIsFalse();
    }

    @Override
    public Page<Customer> getAllCustomer(Pageable pageable) {
        pageable= PageRequest.of(pageable.getPageNumber(),3, Sort.by("firstName"));
        return customerRepository.findAllByIsDeleteIsFalse(pageable);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customer.setDelete(false);
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findByIsDeleteIsFalseAndIdIs(id);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customer.setDelete(true);
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> getAllCustomerByName(Pageable pageable, String s) {
        pageable= PageRequest.of(pageable.getPageNumber(),2, Sort.by("firstName"));
        return customerRepository.findAllByIsDeleteIsFalseAndFirstNameContaining(pageable,s);
    }
}
