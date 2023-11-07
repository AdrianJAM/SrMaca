package com.srmaca.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.srmaca.model.ecommerce.product;

@Repository
public interface productRepository extends JpaRepository<product, Long>{
    //Metodo Para Buscar Producto mediante Nombre
    Optional<product> findByName(String name);
    //Metodo Para Verificar si un producto existe en la bd
    Boolean existsByName(String name);
    //Metodo Para Buscar Producto mediante Id
    Optional<product> findById(Long id);
}