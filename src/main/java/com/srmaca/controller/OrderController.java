package com.srmaca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srmaca.model.ecommerce.Order;
import com.srmaca.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "getOrders", headers = "Accept=application/json")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping(value = "getOrderById/{orderId}", headers = "Accept=application/json")
    public Optional<Order> getOrderById(@PathVariable Long orderId){
        return orderService.getOrderById(orderId);
    }

    @PostMapping(value = "create", headers = "Accept=application/json")
    public void createOrder(@RequestBody Order order){
        orderService.createOrder(order);
    }

    @PutMapping(value = "update/{orderId}", headers = "Accept=application/json")
    public void updateOrder(@PathVariable Long orderId, @RequestBody Order updateOrder){
        orderService.updateOrder(orderId, updateOrder);
    }

    @DeleteMapping("/delete/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }

}