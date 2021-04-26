package com.example.egen.order.service;

import java.util.List;

import com.example.egen.order.entity.Shipping;
import com.example.egen.order.repository.ShippingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    @Autowired 
    private ShippingRepository repository;

    public Shipping saveShipping(Shipping shipping){
        return repository.save(shipping);
    }

    public List <Shipping> saveShippings(List <Shipping> shippings)
    {
        return  repository.saveAll(shippings);
    } 

    public List <Shipping> getShippings()
    {
        return  repository.findAll();
    } 

    public List <Shipping>  getShippingByIds(Iterable<Integer> iterator)
    {
        return  repository.findAllById(iterator);
        
    } 

    public  Shipping getShippingByOrderId(Integer orderId){
        return  repository.findByOrderId(orderId);
    }

    public Integer deleteShippingById(int id)
    {
        repository.deleteById(id);
        return id;
    }

    public Shipping updateShipping(Shipping shipping)
    {
        Shipping existingItem= repository.findById(shipping.getOrder_shipping_id()).orElse(null);
        existingItem.setOrder_shipping_addressline1(shipping.getOrder_shipping_addressline1());
        existingItem.setOrder_shipping_addressline2(shipping.getOrder_shipping_addressline2());
        existingItem.setOrder_shipping_city(shipping.getOrder_shipping_city());
        existingItem.setOrder_shipping_state(shipping.getOrder_shipping_state());
        existingItem.setOrder_shipping_zip(shipping.getOrder_shipping_zip());
        
        return repository.save(existingItem);
    }


}
