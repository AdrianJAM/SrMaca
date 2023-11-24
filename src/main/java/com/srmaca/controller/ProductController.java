package com.srmaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping(value = "update/{id}", headers = "Accept=application/json")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Optional<Product> existingProduct = productService.getProductById(id);

        if (existingProduct.isPresent()) {
            // Actualizar solo los campos que necesitas
            Product productToUpdate = existingProduct.get();
            productToUpdate.setName(updatedProduct.getName());
            // productToUpdate.setBenefits(updatedProduct.getBenefits());
            // Actualizar otros campos según sea necesario

            // Actualizar el campo pillsData
            productToUpdate.setPillsData(updatedProduct.getPillsData());

            // Guardar el producto actualizado en la base de datos
            Product savedProduct = productService.updateProduct(productToUpdate);

            return ResponseEntity.ok(savedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}