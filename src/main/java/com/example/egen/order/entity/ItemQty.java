package com.example.egen.order.entity;

public class ItemQty {
    
    private Integer item_id;
    private Integer item_qty;
    
    public ItemQty(Integer item_id, Integer item_qty) {
        this.item_id = item_id;
        this.item_qty = item_qty;
    }
    public Integer getItem_id() {
        return item_id;
    }
    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }
    public Integer getItem_qty() {
        return item_qty;
    }
    public void setItem_qty(Integer item_qty) {
        this.item_qty = item_qty;
    }
    
    
}
