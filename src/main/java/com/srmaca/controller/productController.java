package com.srmaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.srmaca.model.ecommerce.Product;
import com.srmaca.service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping(value = "create", headers = "Accept=application/json")
    public void createProduct(@RequestBody Product product){
        productService.createProduct(product);
    }

    @GetMapping(value = "getProducts", headers = "Accept=application/json")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping(value = "getProductById/{id}", headers = "Accept=application/json")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping(value = "getProductByName/{name}", headers = "Accept=application/json")
    public List<Product> getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }
}