package com.example.demoormcustomer.services;

import com.example.demoormcustomer.models.Province;

public interface ProvinceService {
    Iterable<Province> findAll() ;
    Province findById(Long id) ;
    void save(Province province) ;
    void remove(Long id) ;
}
