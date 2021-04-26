package com.example.egen.order.entity;

import java.util.List;

public class OrderUpdate {
    
    private Integer order_id;
    private String costumer_id;
    private Integer item_id;
    private Integer item_quantity;
    private List<Integer> paymentId;

    public OrderUpdate(){}

    

    public OrderUpdate(Integer order_id, String costumer_id, Integer item_id, Integer item_quantity,
            List<Integer> paymentId) {
        this.order_id = order_id;
        this.costumer_id = costumer_id;
        this.item_id = item_id;
        this.item_quantity = item_quantity;
        this.paymentId = paymentId;
    }



    public List<Integer> getPaymentId() {
        return paymentId;
    }



    public void setPaymentId(List<Integer> paymentId) {
        this.paymentId = paymentId;
    }



    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getCostumer_id() {
        return costumer_id;
    }

    public void setCostumer_id(String costumer_id) {
        this.costumer_id = costumer_id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(Integer item_quantity) {
        this.item_quantity = item_quantity;
    }
    
    

}
