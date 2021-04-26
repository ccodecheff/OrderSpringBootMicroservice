package com.example.egen.order.entity;

import javax.persistence.*;

import org.hibernate.annotations.Where;



@Entity


@Table(name="order_TBL")
public class Order  {
    
    
    public Order(){}

    @Id
    @GeneratedValue
    @Where(clause="isActive=0")
    private Integer orderId;
    private String order_Status;
    @Column(unique=true)
    private String Costumer_id;
    @Column(name="isActive")
   // @Where(clause="isActive=true")
    private Integer isActive =1;;

    
   
    public Order( String order_Status, String costumer_id) {
       
        this.order_Status = order_Status;
        Costumer_id = costumer_id;
      //  this.isActive = isActive;
    }
    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public String getOrder_Status() {
        return order_Status;
    }
    public void setOrder_Status(String order_Status) {
        this.order_Status = order_Status;
    }
    public String getCostumer_id() {
        return Costumer_id;
    }
    public void setCostumer_id(String costumer_id) {
        Costumer_id = costumer_id;
    }
    public Integer getIsActive() {
        return isActive;
    }
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
    
   
}
