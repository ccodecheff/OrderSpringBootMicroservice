package com.example.egen.order.repository;

import com.example.egen.order.entity.Shipping;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository <Shipping,Integer> {
    public Shipping findByOrderId(Integer orderId);
}
