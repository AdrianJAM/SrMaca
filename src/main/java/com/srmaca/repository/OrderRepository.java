package com.srmaca.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.srmaca.model.ecommerce.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    // Metodo para obtener order por id
    List<Order> findByIdOrder(Long idOrder);
}
