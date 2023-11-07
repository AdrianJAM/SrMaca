package com.srmaca.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.srmaca.model.ecommerce.cart;
import java.util.Optional;

@Repository
public interface cartRepository extends JpaRepository<cart, Long>{
    //Metodo para obtener Cart por ID
    Optional<cart> findById(Long id);
    //Metodo para eliminar

}