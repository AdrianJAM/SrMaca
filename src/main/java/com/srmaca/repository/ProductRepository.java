package com.srmaca.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.srmaca.model.ecommerce.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    //Metodo para buscar por ID
    List<Product> findByIdProduct(Long idProduct);
    //Metodo para buscar por nombre
    List<Product> findByName(String name);
}