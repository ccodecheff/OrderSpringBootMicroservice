package com.example.egen.order.service;

import com.example.egen.order.entity.Order;
import com.example.egen.order.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public Order saveorder(Order order){
        return repository.save(order);
    }

    public List <Order> saveorders(List <Order> orders)
    {
        return  repository.saveAll(orders);
    } 

    public List <Order> getorders()
    {
        return  repository.findAll();
    } 

    public Order getOrderById(Integer id)
    {
        return  repository.findById(id).orElse(null);
      //  findById(id).orElse(null);
        
    } 

    public String deleteOrderById(int id)
    {
        repository.deleteById(id);
        return " Order Removed !!"+id;
    }

    public Order updateOrder(Order order)
    {
        Order existingProduct= repository.findById(order.getOrderId()).orElse(null);
        existingProduct.setOrder_Status(order.getOrder_Status());
        existingProduct.setCostumer_id(order.getCostumer_id());
        existingProduct.setIsActive(order.getIsActive());
        return repository.save(existingProduct);
    }

}
