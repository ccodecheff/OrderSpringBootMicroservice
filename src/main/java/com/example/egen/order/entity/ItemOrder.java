package com.example.egen.order.entity;

import java.util.List;

public class ItemOrder {
    
    private Integer order_id;
    private List <ItemQty> items;
    
    public ItemOrder(){ }

    public ItemOrder(Integer order_id, List<ItemQty> items) {
        this.order_id = order_id;
        this.items = items;
    }
    
    
    public Integer getOrder_id() {
        return order_id;
    }
    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }
    public List<ItemQty> getItems() {
        return items;
    }
    public void setItems(List<ItemQty> items) {
        this.items = items;
    }
}
