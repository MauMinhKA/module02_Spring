package com.codygym.demothymeleaf.services;

import com.codygym.demothymeleaf.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    Student getStudentById(int id);
    void deleteStudentById(int id);
    void saveStudent(Student student);
    Page<Student> findAllStudentByName(String name, Pageable pageable);
    Page<Student> findAllStudent(Pageable pageable);
}
