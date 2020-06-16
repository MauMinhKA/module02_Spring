package com.codygym.demothymeleaf.services.impl;

import com.codygym.demothymeleaf.models.Student;
import com.codygym.demothymeleaf.repository.StudentRepository;
import com.codygym.demothymeleaf.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Page<Student> findAllStudentByName(String name, Pageable pageable) {
        return studentRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Page<Student> findAllStudent(Pageable pageable) {
        return studentRepository.findByOrderByName(pageable);
    }
}
