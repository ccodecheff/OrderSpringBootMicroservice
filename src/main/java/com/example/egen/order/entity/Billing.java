package com.example.egen.order.entity;

import javax.persistence.*;

@Entity
@Table(name="billing_TBL")
public class Billing {

    public Billing(){}
    
    
    @Id
    @GeneratedValue
    private Integer order_billing_id;
    @Column(unique=true)
    private Integer orderId;
    private String order_billing_addressLine1;
    private String order_billing_addressLine2;
    private String order_billing_city;
    private String order_billing_state;
    private Integer order_billing_zip;
    
    public Billing(Integer orderId, String order_billing_addressLine1, String order_billing_addressLine2,
            String order_billing_city, String order_billing_state, Integer order_billing_zip) {
        this.orderId = orderId;
        this.order_billing_addressLine1 = order_billing_addressLine1;
        this.order_billing_addressLine2 = order_billing_addressLine2;
        this.order_billing_city = order_billing_city;
        this.order_billing_state = order_billing_state;
        this.order_billing_zip = order_billing_zip;
    }
    public Integer getOrder_billing_id() {
        return order_billing_id;
    }
    public void setOrder_billing_id(Integer order_billing_id) {
        this.order_billing_id = order_billing_id;
    }
    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public String getOrder_billing_addressLine1() {
        return order_billing_addressLine1;
    }
    public void setOrder_billing_addressLine1(String order_billing_addressLine1) {
        this.order_billing_addressLine1 = order_billing_addressLine1;
    }
    public String getOrder_billing_addressLine2() {
        return order_billing_addressLine2;
    }
    public void setOrder_billing_addressLine2(String order_billing_addressLine2) {
        this.order_billing_addressLine2 = order_billing_addressLine2;
    }
    public String getOrder_billing_city() {
        return order_billing_city;
    }
    public void setOrder_billing_city(String order_billing_city) {
        this.order_billing_city = order_billing_city;
    }
    public String getOrder_billing_state() {
        return order_billing_state;
    }
    public void setOrder_billing_state(String order_billing_state) {
        this.order_billing_state = order_billing_state;
    }
    public Integer getOrder_billing_zip() {
        return order_billing_zip;
    }
    public void setOrder_billing_zip(Integer order_billing_zip) {
        this.order_billing_zip = order_billing_zip;
    }

    

}
