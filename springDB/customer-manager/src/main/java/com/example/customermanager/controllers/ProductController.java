package com.example.customermanager.controllers;

import com.example.customermanager.models.Product;
import com.example.customermanager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ModelAndView getHomeProduct() {
        return new ModelAndView("product/index", "product", productService.getAllProducts());
    }

    @GetMapping("/product/create")
    public ModelAndView getCreateProduct() {
        return new ModelAndView("product/create", "product", new Product());
    }

    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirect) {
        product.setId((long) (Math.random() * 100));
        productService.saveProduct(product);
        redirect.addFlashAttribute("message", "Saved customer successfully!");
        return "redirect:/";

    }
    @GetMapping("/product/edit/{id}")
    public ModelAndView getEditProduct(@PathVariable("id") Long id){
        return new ModelAndView("/product/edit","product",productService.getProductById(id));
    }
    @PostMapping("product/update")
    public String UpdateProduct(Product product,RedirectAttributes redirectAttributes){
        productService.updateProduct(product.getId(),product);
        redirectAttributes.addFlashAttribute("message","edit Successful!!");
        return "redirect:/";
    }
    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message","Delete Successful!!");
        productService.deleteProductById(id);
        return "redirect:/";
    }
    @GetMapping("/product/view/{id}")
    public ModelAndView viewProduct(@PathVariable("id") Long id){
        return new ModelAndView("/product/view","product",productService.getProductById(id));
    }

}
