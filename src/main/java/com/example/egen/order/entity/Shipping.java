package com.example.egen.order.entity;

import javax.persistence.*;
@Entity
@Table(name="shipping_TBL")
public class Shipping {
    
    public Shipping(){}
    

@Id
   @GeneratedValue
    private Integer order_shipping_id;
    @Column(unique=true)
    private Integer orderId;
    private String order_shipping_addressline1;
    private String order_shipping_addressline2;
    private String order_shipping_city;
    private String order_shipping_state;
    private Integer order_shipping_zip;
    
    public Shipping(Integer orderId, String order_shipping_addressline1, String order_shipping_addressline2,
            String order_shipping_city, String order_shipping_state, Integer order_shipping_zip) {
        this.orderId = orderId;
        this.order_shipping_addressline1 = order_shipping_addressline1;
        this.order_shipping_addressline2 = order_shipping_addressline2;
        this.order_shipping_city = order_shipping_city;
        this.order_shipping_state = order_shipping_state;
        this.order_shipping_zip = order_shipping_zip;
    }

    public Integer getOrder_shipping_id() {
        return order_shipping_id;
    }

    public void setOrder_shipping_id(Integer order_shipping_id) {
        this.order_shipping_id = order_shipping_id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrder_shipping_addressline1() {
        return order_shipping_addressline1;
    }

    public void setOrder_shipping_addressline1(String order_shipping_addressline1) {
        this.order_shipping_addressline1 = order_shipping_addressline1;
    }

    public String getOrder_shipping_addressline2() {
        return order_shipping_addressline2;
    }

    public void setOrder_shipping_addressline2(String order_shipping_addressline2) {
        this.order_shipping_addressline2 = order_shipping_addressline2;
    }

    public String getOrder_shipping_city() {
        return order_shipping_city;
    }

    public void setOrder_shipping_city(String order_shipping_city) {
        this.order_shipping_city = order_shipping_city;
    }

    public String getOrder_shipping_state() {
        return order_shipping_state;
    }

    public void setOrder_shipping_state(String order_shipping_state) {
        this.order_shipping_state = order_shipping_state;
    }

    public Integer getOrder_shipping_zip() {
        return order_shipping_zip;
    }

    public void setOrder_shipping_zip(Integer order_shipping_zip) {
        this.order_shipping_zip = order_shipping_zip;
    }

    
    
}
