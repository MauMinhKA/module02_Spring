package com.codegym.demo_provice.repository;

import com.codegym.demo_provice.entity.Customer;
import com.codegym.demo_provice.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province,Long> {
    List<Province> findAllByIsDeleteIsFalse();
}
