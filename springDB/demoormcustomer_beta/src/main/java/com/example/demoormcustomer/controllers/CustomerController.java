package com.example.demoormcustomer.controllers;

import com.example.demoormcustomer.models.Customer;
import com.example.demoormcustomer.models.Province;
import com.example.demoormcustomer.services.CustomerService;
import com.example.demoormcustomer.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping("/create-customer")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    //    @PostMapping("/create-customer")
//    public ModelAndView save(@ModelAttribute Customer customer) {
//        customerService.save(customer);
//        ModelAndView modelAndView = new ModelAndView("/customer/create");
//        modelAndView.addObject("customer", new Customer());
//        modelAndView.addObject("messages", "New customer created success!");
//        return modelAndView;
//    }
    @PostMapping("/create-customer")
    public String createCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer/create";
        }
        if (customer == null) {
            return "404";
        }
        try {
            customerService.save(customer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }

    @GetMapping("/")
    public ModelAndView listCustomer() {
        Iterable<Customer> customerList = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/view");
        modelAndView.addObject("customer", customerList);
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("customer/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customer")
    public ModelAndView update(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated Success !");
        return modelAndView;
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("customer/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.delete(customer.getId());
        redirectAttributes.addFlashAttribute("messages", "delete success!");
        return "redirect:/";
    }

}
