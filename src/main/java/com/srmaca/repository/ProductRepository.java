package com.srmaca.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.srmaca.model.ecommerce.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    //Metodo Para Buscar Producto mediante Nombre
    Optional<Product> findByName(String name);
    //Metodo Para Verificar si un producto existe en la bd
    Boolean existsByName(String name);
    //Metodo Para Buscar Producto mediante Id
    Optional<Product> findByidProduct(Long idProduct);
}