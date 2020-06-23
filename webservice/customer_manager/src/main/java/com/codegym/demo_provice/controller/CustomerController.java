package com.codegym.demo_provice.controller;

import com.codegym.demo_provice.entity.Customer;
import com.codegym.demo_provice.entity.Province;
import com.codegym.demo_provice.service.CustomerService;
import com.codegym.demo_provice.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("")
    public ModelAndView showListCustomer(Pageable pageable,@RequestParam(value = "s",required = false,defaultValue = "")String s) {
        if(s==null) {
            s="";
        }
        Page<Customer> customers=customerService.getAllCustomerByName(pageable,s);
        ModelAndView modelAndView=new ModelAndView("customer/list","customers",customers);
        modelAndView.addObject("s",s);
        return  modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreateCustomer() {
        ModelAndView modelAndView=new ModelAndView("customer/create","customer",new Customer());
        modelAndView.addObject("provinces",provinceService.getAllProvince());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createCustomer(@Valid @ModelAttribute("customer")Customer customer, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "customer/create";
        }
        if(customer==null) {
            return "404";
        }
        try {
            customerService.saveCustomer(customer);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:";
    }

    @GetMapping("delete/{id}")
    public ModelAndView showFormDeleteCustomer(@PathVariable("id")Long id) {
        return new ModelAndView("customer/delete","customer",customerService.getCustomerById(id));
    }

    @PostMapping("delete")
    public String deleteCustomer(@ModelAttribute("customer")Customer customer, RedirectAttributes redirect) {
        try {
            customerService.deleteCustomer(customer);
        } catch (Exception e) {
            return "500";
        }
        redirect.addFlashAttribute("message","Delete successfully");
        return "redirect: ";
    }
}
