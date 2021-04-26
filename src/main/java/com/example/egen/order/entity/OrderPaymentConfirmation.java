package com.example.egen.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrderPaymentConfirmation {
   
    private Integer orderId;
    @JsonIgnore
    private Integer payment_id;
    private  Double  total_price;
    private String Confirmation_number;
    
    public OrderPaymentConfirmation(Integer orderId, Integer payment_id, Double total_price,
            String confirmation_number) {
        this.orderId = orderId;
        this.payment_id = payment_id;
        this.total_price = total_price;
        Confirmation_number = confirmation_number;
    }

    public OrderPaymentConfirmation(){}

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Integer payment_id) {
        this.payment_id = payment_id;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public String getConfirmation_number() {
        return Confirmation_number;
    }

    public void setConfirmation_number(String confirmation_number) {
        Confirmation_number = confirmation_number;
    }

        
}
