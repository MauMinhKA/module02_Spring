package com.example.demo.services;


import com.example.demo.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    Page<Student> findAllStudentByName(String name, Pageable pageable);
    Page<Student> findAllStudent(Pageable pageable);
}
