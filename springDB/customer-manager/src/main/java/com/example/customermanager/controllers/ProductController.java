package com.example.customermanager.controllers;

import com.example.customermanager.models.Product;
import com.example.customermanager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> listAllProducts() {
        List<Product> products=productService.getAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
        System.out.println("Fetching Customer with id " + id);
        Product product = productService.getProductById(id);
        if (product == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
    @PostMapping("/product")
   public ResponseEntity<Void> createProduct(@RequestBody Product product, UriComponentsBuilder uriComponentsBuilder){
        System.out.println("creating product" +product.getName());
        productService.saveProduct(product);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri());
        return new ResponseEntity<Void>(httpHeaders,HttpStatus.CREATED);
    }
    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        System.out.println("Updating Product " + id);

        Product currentProduct = productService.getProductById(id);
        if (currentProduct == null) {
            System.out.println("Product with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        currentProduct.setName(product.getName());
        currentProduct.setDescription(product.getDescription());
        currentProduct.setPrice(product.getPrice());
        productService.saveProduct(currentProduct);
        return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
    }
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Customer with id " + id);

        Product customer = productService.getProductById(id);
        if (customer == null) {
            System.out.println("Unable to delete. Customer with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        productService.deleteProductById(id);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }


}
