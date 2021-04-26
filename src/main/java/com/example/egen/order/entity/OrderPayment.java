package com.example.egen.order.entity;

import java.util.List;

public class OrderPayment {
    
    private Integer order_id;
    
    private List<Payment> paymentInfo;
    
    public List<Payment> getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(List<Payment> paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public OrderPayment(){}

    public OrderPayment(Integer order_id, List<Payment> payments) {
        
        this.order_id = order_id;
       
        this.paymentInfo = payments;
    }
    public Integer getOrder_id() {
        return order_id;
    }
    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }
    
    
    
}
