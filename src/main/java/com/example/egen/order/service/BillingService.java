package com.example.egen.order.service;

import java.util.List;

import com.example.egen.order.entity.Billing;
import com.example.egen.order.repository.BillingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {
    
    @Autowired 
    private BillingRepository repository;

    public Billing saveBilling(Billing billing){
        return repository.save(billing);
    }

    public List <Billing> saveBillings(List <Billing> billings)
    {
        return  repository.saveAll(billings);
    } 

    public List <Billing> getBilling()
    {
        return  repository.findAll();
    } 

    public List <Billing>  getBillingByIds(Iterable<Integer> iterator)
    {
        return  repository.findAllById(iterator);    
    } 

    public  Billing getBillingByOrderId(Integer orderId){
        return  repository.findByOrderId(orderId);
    }


    public Integer deleteBillingById(int id)
    {
        repository.deleteById(id);
        return id;
    }

    public Billing updateBilling(Billing billing)
    {
        Billing existingItem= repository.findById(billing.getOrder_billing_id()).orElse(null);
        existingItem.setOrder_billing_addressLine1(billing.getOrder_billing_addressLine1());
        existingItem.setOrder_billing_addressLine2(billing.getOrder_billing_addressLine2());
        existingItem.setOrder_billing_city(billing.getOrder_billing_city());
        existingItem.setOrder_billing_state(billing.getOrder_billing_state());
        existingItem.setOrder_billing_zip(billing.getOrder_billing_zip());
        
        return repository.save(existingItem);
    }

    
}
