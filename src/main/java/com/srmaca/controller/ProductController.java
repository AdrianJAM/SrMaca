package com.srmaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.srmaca.model.ecommerce.Product;
import com.srmaca.service.ProductService;
import java.util.List;
import java.util.Optional;


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


    @PutMapping(value = "updateProduct/{id}", headers = "Accept=application/json")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct){
        try {
            Product existingProduct = productService.getProductById(id).orElseThrow();
            if(existingProduct == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setBenefits(updatedProduct.getBenefits());
            existingProduct.setImagebg(updatedProduct.getImagebg());
            existingProduct.setTitle(updatedProduct.getTitle());
            existingProduct.setTransitionname(updatedProduct.getTransitionname());
            existingProduct.setBgstart(updatedProduct.getBgstart());
            existingProduct.setTextcolor(updatedProduct.getTextcolor());
            existingProduct.setDetailstitle(updatedProduct.getDetailstitle());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPillsData(updatedProduct.getPillsData());
            existingProduct.setAddTextData(updatedProduct.getAddTextData());
            existingProduct.setWhatis(updatedProduct.getWhatis());
            existingProduct.setHowworks(updatedProduct.getHowworks());
            existingProduct.setIngredients(updatedProduct.getIngredients());
            existingProduct.setComparation(updatedProduct.getComparation());
            existingProduct.setHowuse(updatedProduct.getHowuse());
            Product savedProduct = productService.saveProduct(existingProduct);

            return ResponseEntity.ok(savedProduct);

        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}