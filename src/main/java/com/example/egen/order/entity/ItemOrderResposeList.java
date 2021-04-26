package com.example.egen.order.entity;

import java.util.ArrayList;
import java.util.List;

public class ItemOrderResposeList {

    List<ItemOrderResponse> itemOrderReponse = new ArrayList<>();

    public ItemOrderResposeList(List<ItemOrderResponse> itemOrderReponse) {
        this.itemOrderReponse = itemOrderReponse;
    }

    public List<ItemOrderResponse> getItemOrderReponse() {
        return itemOrderReponse;
    }

    public void setItemOrderReponse(List<ItemOrderResponse> itemOrderReponse) {
        this.itemOrderReponse = itemOrderReponse;
    }
    

}
