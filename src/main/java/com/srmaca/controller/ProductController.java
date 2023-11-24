package com.srmaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {

    Product existingProduct = productService.getProductById(id)
    .orElseThrow();

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setImagebg(product.getImagebg());
        existingProduct.setTitle(product.getTitle());
        existingProduct.setTransitionname(product.getTransitionname());
        existingProduct.setBgstart(product.getBgstart());
        existingProduct.setTextcolor(product.getTextcolor());
        existingProduct.setDetailstitle(product.getDetailstitle());
        existingProduct.setWhatis(product.getWhatis());
        existingProduct.setHowworks(product.getHowworks());
        existingProduct.setHowuse(product.getHowuse());
        existingProduct.setBenefits(product.getBenefits());
        existingProduct.setPillsData(product.getPillsData());
        existingProduct.setAddTextData(product.getAddTextData());
        existingProduct.setIngredients(product.getIngredients());
        existingProduct.setComparation(product.getComparation());

        Product updatedProduct = productService.saveProduct(existingProduct);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK); 
    }
}