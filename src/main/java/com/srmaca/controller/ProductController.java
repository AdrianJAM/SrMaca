package com.srmaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.srmaca.model.ecommerce.Product;
import com.srmaca.service.ProductService;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ObjectMapper objectMapper;
    
    public ProductController(ProductService productService, ObjectMapper objectMapper){
        this.productService = productService;
        this.objectMapper = objectMapper;
    }

    @GetMapping(value = "getProducts", headers = "Accept=application/json")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping(value = "getProductById/{id}", headers = "Accept=application/json")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping(value = "createProduct", headers = "Accept=application/json")
    public ResponseEntity<Product> createProduct(@RequestBody Map<String, Object> request){
        try {
            Product product = new Product();
            
            product.setImagebg((String) request.get("imagebg"));
            product.setTitle((String) request.get("title"));
            product.setTransitionname((String) request.get("transitionname"));
            product.setBgstart((String) request.get("bgstart"));
            product.setTextcolor((String) request.get("textcolor"));
            product.setDetailstitle((String) request.get("detailstitle"));
            product.setDescription((String) request.get("description"));
            product.setWhatis((String) request.get("whatis"));
            product.setHowworks((String) request.get("howworks"));
            product.setHowuse((String) request.get("howuse"));

            if (
                request.containsKey("pillsData") 
                && 
                request.containsKey("addTextData") 
                &&
                request.containsKey("ingredients")
                &&
                request.containsKey("comparation")
                &&
                request.containsKey("benefits")
                &&
                request.containsKey("ingredients")
                ) {
                
                    String pillsDataAsString = objectMapper.writeValueAsString(request.get("pillsData"));
                    String addTextDataAsString = objectMapper.writeValueAsString(request.get("addTextData"));
                    String ingredientsAsString = objectMapper.writeValueAsString(request.get("ingredients"));
                    String comparationAsString = objectMapper.writeValueAsString(request.get("comparation"));
                    String benefitsAsString = objectMapper.writeValueAsString(request.get("benefits"));

                    product.setPillsData(pillsDataAsString);
                    product.setAddTextData(addTextDataAsString);
                    product.setIngredients(ingredientsAsString);
                    product.setComparation(comparationAsString);
                    product.setBenefits(benefitsAsString);
            }

            Product savedProduct = productService.createProduct(product);
            return ResponseEntity.ok(savedProduct);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el producto", e);
        }
    }

    @PutMapping(value = "updateProduct/{id}", headers = "Accept=application/json")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id ,@RequestBody Map<String, Object> request){
            try {
            Product product = productService.getProductById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            
            product.setImagebg((String) request.get("imagebg"));
            product.setTitle((String) request.get("title"));
            product.setTransitionname((String) request.get("transitionname"));
            product.setBgstart((String) request.get("bgstart"));
            product.setTextcolor((String) request.get("textcolor"));
            product.setDetailstitle((String) request.get("detailstitle"));
            product.setDescription((String) request.get("description"));
            product.setWhatis((String) request.get("whatis"));
            product.setHowworks((String) request.get("howworks"));
            product.setHowuse((String) request.get("howuse"));

            if (
                request.containsKey("pillsData") 
                || 
                request.containsKey("addTextData") 
                ||
                request.containsKey("ingredients")
                ||
                request.containsKey("comparation")
                ||
                request.containsKey("benefits")
                ||
                request.containsKey("ingredients")
                ) {
                
                    String pillsDataAsString = objectMapper.writeValueAsString(request.get("pillsData"));
                    String addTextDataAsString = objectMapper.writeValueAsString(request.get("addTextData"));
                    String ingredientsAsString = objectMapper.writeValueAsString(request.get("ingredients"));
                    String comparationAsString = objectMapper.writeValueAsString(request.get("comparation"));
                    String benefitsAsString = objectMapper.writeValueAsString(request.get("benefits"));

                    product.setPillsData(pillsDataAsString);
                    product.setAddTextData(addTextDataAsString);
                    product.setIngredients(ingredientsAsString);
                    product.setComparation(comparationAsString);
                    product.setBenefits(benefitsAsString);
            }

            Product updatedProduct = productService.updateProduct(product);
            return ResponseEntity.ok(updatedProduct);
            } catch (Exception e) {
                throw new RuntimeException("Error al actualizar el producto", e);
        }
    }
}

    /*  @GetMapping(value = "getProductByName/{name}", headers = "Accept=application/json")
    public List<Product> getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }
    */

    /*@PutMapping(value = "updatePillsData/{productId}", consumes = "application/json", produces = "application/json")
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
    }*/