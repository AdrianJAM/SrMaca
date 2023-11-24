package com.srmaca.service;

import com.srmaca.model.ecommerce.Product;
import com.srmaca.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    //Metodo para crear producto
    public void createProduct(Product product){
        productRepository.save(product);
    }
    //Metodo para obtener lista de productos
    public List<Product> getProducts(){
        List<Product> products = productRepository.findAll();
        return products;
    }
    //Metodo para obtener producto por ID
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }
    //Metodo para obtener producto por su nombre
    public List<Product> getProductByName(String name){
        return productRepository.findByName(name);
    }
    //Metodo para actualizar datos de producto
    public Product updateProduct(Product product){
        return productRepository.save(product);
    }
}