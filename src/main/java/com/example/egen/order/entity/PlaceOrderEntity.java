package com.example.egen.order.entity;

import java.util.List;

public class PlaceOrderEntity {

private Integer order_id;
private String costumer_id;
private Shipping order_shipping;
private  Billing order_billing;
private List<Payment> paymentInfo;

public PlaceOrderEntity(){}

public PlaceOrderEntity(Integer order_id, String costumer_id, Shipping order_shipping, Billing order_billing,
        List<Payment> paymentInfo) {
    this.order_id = order_id;
    this.costumer_id = costumer_id;
    this.order_shipping = order_shipping;
    this.order_billing = order_billing;
    this.paymentInfo = paymentInfo;
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

public Shipping getOrder_shipping() {
    return order_shipping;
}

public void setOrder_shipping(Shipping order_shipping) {
    this.order_shipping = order_shipping;
}

public Billing getOrder_billing() {
    return order_billing;
}

public void setOrder_billing(Billing order_billing) {
    this.order_billing = order_billing;
}

public List<Payment> getPaymentInfo() {
    return paymentInfo;
}

public void setPaymentInfo(List<Payment> paymentInfo) {
    this.paymentInfo = paymentInfo;
}






}
