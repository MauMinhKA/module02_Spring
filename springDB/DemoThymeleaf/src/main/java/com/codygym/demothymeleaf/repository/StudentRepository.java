package com.codygym.demothymeleaf.repository;

import com.codygym.demothymeleaf.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Page<Student> findAllByNameContaining(String name, Pageable pageable);
    Page<Student> findByOrderByName(Pageable pageable);
}
