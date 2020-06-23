package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Pageable;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public ModelAndView listStudent(@RequestParam(name = "search", required = false) String search,
                                    @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("student/view");
        if (search != null) {
            Page<Student> studentList = studentService.findAllStudentByName(search, pageable);
            modelAndView.addObject("students", studentList);
        } else {
            modelAndView.addObject("students", studentService.findAllStudent(pageable));
        }
        return modelAndView;
    }
}
