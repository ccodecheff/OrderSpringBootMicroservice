package com.example.egen.order.entity;

public class GetBilling {
    

    private String order_billing_addressLine1;
    private String order_billing_addressLine2;
    private String order_billing_city;
    private String order_billing_state;
    private Integer order_billing_zip;
    
    public GetBilling(){}

    
    public GetBilling(String order_billing_addressLine1, String order_billing_addressLine2, String order_billing_city,
            String order_billing_state, Integer order_billing_zip) {
        this.order_billing_addressLine1 = order_billing_addressLine1;
        this.order_billing_addressLine2 = order_billing_addressLine2;
        this.order_billing_city = order_billing_city;
        this.order_billing_state = order_billing_state;
        this.order_billing_zip = order_billing_zip;
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
