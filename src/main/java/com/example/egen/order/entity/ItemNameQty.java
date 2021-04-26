package com.example.egen.order.entity;

public class ItemNameQty {
    private String ItemName;
    private Integer ItemQuantity;
    
    public ItemNameQty(){}

    public ItemNameQty(String itemName, Integer itemQuantity) {
        ItemName = itemName;
        ItemQuantity = itemQuantity;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public Integer getItemQuantity() {
        return ItemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        ItemQuantity = itemQuantity;
    }

    
}
