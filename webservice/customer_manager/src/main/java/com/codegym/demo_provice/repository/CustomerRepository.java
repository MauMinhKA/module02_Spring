package com.codegym.demo_provice.repository;

import com.codegym.demo_provice.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value ="select * from customers c where c.is_delete=false" ,nativeQuery = true)
    List<Customer> findAllByIsDeleteIsFalse();
    Customer findByIsDeleteIsFalseAndIdIs(Long id);
    Page<Customer> findAllByIsDeleteIsFalse(Pageable pageable);
    Page<Customer> findAllByIsDeleteIsFalseAndFirstNameContaining(Pageable pageable, String s);
}
