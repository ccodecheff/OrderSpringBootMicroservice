package com.example.egen.order.repository;

import com.example.egen.order.entity.Billing;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository  extends JpaRepository <Billing,Integer> {
    public Billing findByOrderId(Integer orderId);
}
