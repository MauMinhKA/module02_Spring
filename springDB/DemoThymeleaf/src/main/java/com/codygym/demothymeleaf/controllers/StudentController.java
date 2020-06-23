package com.codygym.demothymeleaf.controllers;

import com.codygym.demothymeleaf.models.Student;
import com.codygym.demothymeleaf.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public ModelAndView getHomeStudent(@RequestParam(name = "search", required = false) String search,
                                       @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("student/index");
        if (search != null) {
            Page<Student> studentList = studentService.findAllStudentByName(search, pageable);
            modelAndView.addObject("students", studentList);
        } else {
            modelAndView.addObject("students", studentService.findAllStudent(pageable));
        }
        return modelAndView;
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Delete Successful!!");
        studentService.deleteStudentById(id);
        return "redirect:/";
    }

    @GetMapping("/student/edit/{id}")
    public ModelAndView getEditPage(@PathVariable Integer id) {
        return new ModelAndView("student/edit", "student", studentService.getStudentById(id));
    }

    @PostMapping("/student/edit")
    public String editStudent(@ModelAttribute Student student
            , RedirectAttributes redirectAttributes
    ) {
        redirectAttributes.addFlashAttribute("message", "Edit successful!!");
        studentService.saveStudent(student);
        return "redirect:/";
    }
}
