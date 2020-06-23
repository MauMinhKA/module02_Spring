package com.codygym.demothymeleaf.repository;

import com.codygym.demothymeleaf.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    Page<Student> findAllByNameContaining(String name, Pageable pageable);
    Page<Student> findByOrderByName(Pageable pageable);
}
