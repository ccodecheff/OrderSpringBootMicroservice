package com.example.egen.order.entity;

import java.util.List;

public class GetOrder {

    private String CustomerId;
    private String  PaymentConfirmationId;
    private List<ItemNameQty> OrderedItemInfo;
    private Double TotalPrice;
    private GetBilling BillingInfo;
    private GetShipping ShippingInfo;
    private List<Payment> PaymentInfo; 

    public GetOrder(){
    }

    public GetOrder(String customerId, String paymentConfirmationId, List<ItemNameQty> orderedItemInfo,
            Double totalPrice, GetBilling billingInfo, GetShipping shippingInfo, List<Payment> paymentInfo) {
        CustomerId = customerId;
        PaymentConfirmationId = paymentConfirmationId;
        OrderedItemInfo = orderedItemInfo;
        TotalPrice = totalPrice;
        BillingInfo = billingInfo;
        ShippingInfo = shippingInfo;
        PaymentInfo = paymentInfo;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getPaymentConfirmationId() {
        return PaymentConfirmationId;
    }

    public void setPaymentConfirmationId(String paymentConfirmationId) {
        PaymentConfirmationId = paymentConfirmationId;
    }

    public List<ItemNameQty> getOrderedItemInfo() {
        return OrderedItemInfo;
    }

    public void setOrderedItemInfo(List<ItemNameQty> orderedItemInfo) {
        OrderedItemInfo = orderedItemInfo;
    }

    public Double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        TotalPrice = totalPrice;
    }

    public GetBilling getBillingInfo() {
        return BillingInfo;
    }

    public void setBillingInfo(GetBilling billingInfo) {
        BillingInfo = billingInfo;
    }

    public GetShipping getShippingInfo() {
        return ShippingInfo;
    }

    public void setShippingInfo(GetShipping shippingInfo) {
        ShippingInfo = shippingInfo;
    }

    public List<Payment> getPaymentInfo() {
        return PaymentInfo;
    }

    public void setPaymentInfo(List<Payment> paymentInfo) {
        PaymentInfo = paymentInfo;
    }
        
}
