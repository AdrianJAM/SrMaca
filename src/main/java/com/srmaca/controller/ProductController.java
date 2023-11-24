package com.srmaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.srmaca.model.ecommerce.Product;
import com.srmaca.model.ecommerce.data.AddTextData;
import com.srmaca.model.ecommerce.data.PillsData;
import com.srmaca.model.ecommerce.data.ResourceNotFoundException;
import com.srmaca.service.ProductService;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ObjectMapper objectMapper;
    
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

    @PutMapping(value = "updatePillsData/{productId}", consumes = "application/json", produces = "application/json")
    public String updatePillsData(@PathVariable Long productId, @RequestBody PillsData updatedPillsData) {
        // Convertir PillsData a JSON
        String pillsDataJson;
        try {
            pillsDataJson = objectMapper.writeValueAsString(updatedPillsData);
        } catch (JsonProcessingException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
                    "Error converting PillsData to JSON");
        }

        // Buscar el producto
        Product product = productService.getProductById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        // Actualizar el campo pillsData
        product.setPillsData(pillsDataJson);

        // Guardar el producto actualizado en la base de datos
        productService.updateProduct(product);

        return "PillsData updated successfully";
    }

    @PutMapping(value = "updateAddTextData/{productId}", consumes = "application/json", produces = "application/json")
    public String updateAddTextData(@PathVariable Long productId, @RequestBody AddTextData updatedAddTextData) {
        // Convertir PillsData a JSON
        String addTextDataJson;
        try {
            addTextDataJson = objectMapper.writeValueAsString(updatedAddTextData);
        } catch (JsonProcessingException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
                    "Error converting PillsData to JSON");
        }

        // Buscar el producto
        Product product = productService.getProductById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        // Actualizar el campo pillsData
        product.setAddTextData(addTextDataJson);

        // Guardar el producto actualizado en la base de datos
        productService.updateProduct(product);

        return "AddTextData updated successfully";
    }
}