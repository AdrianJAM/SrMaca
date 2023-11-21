package com.srmaca.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srmaca.model.ecommerce.Order;
import com.srmaca.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    // Metodo para obtener lista de orders
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }
    // Metodo para obtener order por id
    public Optional<Order> getOrderById(Long id){
        return orderRepository.findById(id);
    }

    // Metodo para crear una order
    public void createOrder(Order order){
        orderRepository.save(order);
    }

    public void updateOrder(Long orderId, Order updatedOrder) {
        Optional<Order> existingOrder = orderRepository.findById(orderId);
        if (existingOrder.isPresent()) {
            Order orderToUpdate = existingOrder.get();
            orderToUpdate.setOrderStatus(updatedOrder.getOrderStatus());
            orderToUpdate.setTotal_amount(updatedOrder.getTotal_amount());
            orderRepository.save(orderToUpdate);
        } else {
            // Manejo de error si la orden no se encuentra
            throw new RuntimeException("Order not found with id: " + orderId);
        }
    }

    public void deleteOrder(Long orderId){
        Optional<Order> existingOrder = orderRepository.findById(orderId);
        if(existingOrder.isPresent()){
            orderRepository.deleteById(orderId);
        } else{
            throw new RuntimeException("Order not found with id: " + orderId);
        }
    }
}