package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;


    @Override
    public Page<Student> findAllStudentByName(String name, Pageable pageable) {
        return studentRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Page<Student> findAllStudent(Pageable pageable) {
        return studentRepository.findByOrderByName(pageable);
    }
}
