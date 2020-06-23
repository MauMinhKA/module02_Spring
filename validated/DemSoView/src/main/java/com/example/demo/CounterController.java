package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("mycounter")
public class CounterController {
    
    @ModelAttribute("mycounter")
    public MyCounter setUpCounter() {
        return new MyCounter();
    }

    @GetMapping("/")
    public String get(@ModelAttribute("mycounter") MyCounter myCounter) {
        myCounter.increment();
        return "index";
    }
}