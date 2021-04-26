package com.example.egen.order.repository;
import com.example.egen.order.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository <Order,Integer>{
   // public Order findByOrderId(Integer orderId);
}
