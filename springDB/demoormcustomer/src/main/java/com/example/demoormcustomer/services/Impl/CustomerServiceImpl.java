package com.example.demoormcustomer.services.Impl;

import com.example.demoormcustomer.models.Customer;
import com.example.demoormcustomer.models.Province;
import com.example.demoormcustomer.repository.CustomerRepository;
import com.example.demoormcustomer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository ;
    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
      customerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }

//    @Override
//    public void updateProduct(Long id, Customer customer) {
//        customerRepository.updateProduct(id,customer);
//    }
}
