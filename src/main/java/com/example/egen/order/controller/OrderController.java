package com.example.egen.order.controller;

import java.util.*;

import com.example.egen.order.entity.Order;
import com.example.egen.order.entity.OrderPayment;
import com.example.egen.order.entity.OrderPaymentConfirmation;
import com.example.egen.order.entity.OrderUpdate;
import com.example.egen.order.entity.PaymentOrderResponse;
import com.example.egen.order.entity.PaymentPriceUpdate;
import com.example.egen.order.entity.ItemCustomer;
import com.example.egen.order.entity.ItemNameQty;
import com.example.egen.order.entity.ItemOrder;
import com.example.egen.order.entity.ItemOrderQty;
import com.example.egen.order.entity.ItemOrderResponse;
import com.example.egen.order.entity.Billing;
import com.example.egen.order.entity.GetBilling;
import com.example.egen.order.entity.GetOrder;
import com.example.egen.order.entity.GetShipping;
import com.example.egen.order.entity.ItemAmountResponse;
import com.example.egen.order.entity.Shipping;


import com.example.egen.order.entity.PlaceOrderEntity;
import com.example.egen.order.service.OrderService;
import com.example.egen.order.service.BillingService;
import com.example.egen.order.service.ShippingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//REST API for Order Microservice

@RestController
@Api(value = "Order", description = "REST API for Order Microservice", tags = { "Order Controller" })
public class OrderController {
    
    private WebClient webClient;

    public OrderController(WebClient webClient){
        this.webClient=webClient;
    }
    @Autowired
    private OrderService orderservice;

    @Autowired
    private BillingService billingService;

    @Autowired
    private ShippingService shippingService;
    
   

    @PostMapping("/createOrder")
    public ItemOrder createOrder(@RequestBody ItemCustomer data){
    
        System.out.println(data.getCustomer_id());
       
        Order order= new Order("pending", data.getCustomer_id());
        order=orderservice.saveorder(order);
       
        System.out.println("saved order id!!"+order.getOrderId());
        ItemOrder itemOrder= new ItemOrder(order.getOrderId(),data.getItem_qty());
    
        return itemOrder;
    }

   
    @PostMapping("/placeOrder")
    public  OrderPaymentConfirmation PlaceOrder(@RequestBody PlaceOrderEntity data){
    
        //   saving shipping data
        Shipping shipping= new Shipping();
        shipping.setOrderId(data.getOrder_id());
        shipping.setOrder_shipping_addressline1(data.getOrder_shipping().getOrder_shipping_addressline1());
        shipping.setOrder_shipping_addressline2(data.getOrder_shipping().getOrder_shipping_addressline2());
        shipping.setOrder_shipping_city(data.getOrder_shipping().getOrder_shipping_city());
        shipping.setOrder_shipping_state(data.getOrder_shipping().getOrder_shipping_state());
        shipping.setOrder_shipping_zip(data.getOrder_shipping().getOrder_shipping_zip());
        shippingService.saveShipping(shipping);

            // saving billing data
        Billing billing= new Billing();
        billing.setOrderId(data.getOrder_id());
        billing.setOrder_billing_addressLine1(data.getOrder_billing().getOrder_billing_addressLine1());
        billing.setOrder_billing_addressLine2(data.getOrder_billing().getOrder_billing_addressLine2());
        billing.setOrder_billing_city(data.getOrder_billing().getOrder_billing_city());
        billing.setOrder_billing_state(data.getOrder_billing().getOrder_billing_state());
        billing.setOrder_billing_zip(data.getOrder_billing().getOrder_billing_zip());
        billingService.saveBilling(billing);    

         OrderPayment orderPayment= new OrderPayment(data.getOrder_id(),data.getPaymentInfo());
         System.out.println("Payment objects**"+orderPayment.getPaymentInfo());

         OrderPaymentConfirmation orderPaymentConfirmation = webClient 
        .post()
        .uri("http://localhost:9192/saveOrderPayment")
        .body(Mono.just(orderPayment), OrderPayment.class)
        .retrieve().bodyToMono(OrderPaymentConfirmation.class).share().block();
       
        Order order= new Order();
       order= orderservice.getOrderById(orderPaymentConfirmation.getOrderId());
       order.setCostumer_id(order.getCostumer_id());
        order.setOrder_Status("Complete");
      // order.setIsActive(true);
        order=orderservice.saveorder(order);
      
       return orderPaymentConfirmation;
     
    }

    @PostMapping("/createOrders")
    public List<ItemOrder> createOrders(@RequestBody List<ItemCustomer> orders){
        
        List<ItemOrder> ItemOrders= new ArrayList<>();
        
        for(ItemCustomer data: orders){
        
            System.out.println(data.getCustomer_id());
        
            Order order= new Order("pending", data.getCustomer_id());
            order=orderservice.saveorder(order);
        
            System.out.println("saved order id!!"+order.getOrderId());
            ItemOrder itemOrder= new ItemOrder(order.getOrderId(),data.getItem_qty());
            ItemOrders.add(itemOrder);
        }

        return ItemOrders;
    }
    
    @PostMapping("/placeOrders")
       public List<OrderPaymentConfirmation> placeOrders(@RequestBody List<PlaceOrderEntity> orders){
        
        List<OrderPaymentConfirmation> OrderPaymentConfirmationList= new ArrayList<>();
        for(PlaceOrderEntity data: orders){

            //   saving shipping data
       Shipping shipping= new Shipping();
       shipping.setOrderId(data.getOrder_id());
       shipping.setOrder_shipping_addressline1(data.getOrder_shipping().getOrder_shipping_addressline1());
       shipping.setOrder_shipping_addressline2(data.getOrder_shipping().getOrder_shipping_addressline2());
       shipping.setOrder_shipping_city(data.getOrder_shipping().getOrder_shipping_city());
       shipping.setOrder_shipping_state(data.getOrder_shipping().getOrder_shipping_state());
       shipping.setOrder_shipping_zip(data.getOrder_shipping().getOrder_shipping_zip());
       shippingService.saveShipping(shipping);

           // saving billing data
       Billing billing= new Billing();
       billing.setOrderId(data.getOrder_id());
       billing.setOrder_billing_addressLine1(data.getOrder_billing().getOrder_billing_addressLine1());
       billing.setOrder_billing_addressLine2(data.getOrder_billing().getOrder_billing_addressLine2());
       billing.setOrder_billing_city(data.getOrder_billing().getOrder_billing_city());
       billing.setOrder_billing_state(data.getOrder_billing().getOrder_billing_state());
       billing.setOrder_billing_zip(data.getOrder_billing().getOrder_billing_zip());
       billingService.saveBilling(billing);


          

        OrderPayment orderPayment= new OrderPayment(data.getOrder_id(),data.getPaymentInfo());
        OrderPaymentConfirmation orderPaymentConfirmation = webClient 
       .post()
       .uri("http://localhost:9192/saveOrderPayment")
       .body(Mono.just(orderPayment), OrderPayment.class)
       .retrieve().bodyToMono(OrderPaymentConfirmation.class).share().block();
      
       Order order= new Order();
       order= orderservice.getOrderById(orderPaymentConfirmation.getOrderId());
       order.setCostumer_id(order.getCostumer_id());
       order.setOrder_Status("Complete");
      // order.setIsActive();
       order=orderservice.saveorder(order);

       OrderPaymentConfirmationList.add(orderPaymentConfirmation);
     
        }  
       
      return OrderPaymentConfirmationList;
     
       
       } 
 
    @ApiOperation(value = "<Your Message>", hidden = true)
    @GetMapping("/orders")
    public List <Order> getOrders(){
        return orderservice.getorders();
    }

    @GetMapping("/orderById/{id}")
    public GetOrder getOrderById(@PathVariable("id")  Integer orderId){
     
        ItemOrderResponse[] itemOrderReponse = webClient 
        .get()
        .uri("http://localhost:9191/getOrderItem/"+orderId)
        .retrieve().bodyToMono(ItemOrderResponse[].class).share().block();
       
        List<ItemNameQty> itemNameQtyList= new ArrayList<>();

        
        for(ItemOrderResponse temp: itemOrderReponse){
            ItemNameQty itemNameQty= new ItemNameQty();
            itemNameQty.setItemName(temp.getItemName());
            itemNameQty.setItemQuantity(temp.getItemQty());
            itemNameQtyList.add(itemNameQty);
        }

        PaymentOrderResponse paymentOrderResponse= webClient 
        .get()
        .uri("http://localhost:9192/PaymentByOrderId/"+orderId)
        .retrieve().bodyToMono(PaymentOrderResponse.class).share().block();
        
        Order order= orderservice.getOrderById(orderId);
        Shipping shipping = shippingService.getShippingByOrderId(orderId);
        Billing billing = billingService.getBillingByOrderId(orderId);
        
        GetBilling getBilling= new GetBilling(
            billing.getOrder_billing_addressLine1(),
            billing.getOrder_billing_addressLine2(),
            billing.getOrder_billing_city(),
            billing.getOrder_billing_state(),
            billing.getOrder_billing_zip()
        );

        GetShipping getShipping= new GetShipping(
            shipping.getOrder_shipping_addressline1(),
            shipping.getOrder_shipping_addressline2(),
            shipping.getOrder_shipping_city(),
            shipping.getOrder_shipping_state(),
            shipping.getOrder_shipping_zip()
        );    

        GetOrder getOrder= new GetOrder(
            order.getCostumer_id(),
            paymentOrderResponse.getConfirmationNumber(),
            itemNameQtyList,
            paymentOrderResponse.getTotalPrice(),
            getBilling,
            getShipping,
            paymentOrderResponse.getPaymentInfo()
        );

      return getOrder;
    }
    
    @PutMapping("/updateBatchOrder")
    public  String updateBatchOrder(@RequestBody OrderUpdate orderupdate){
      
      
       ItemOrderQty itemOrderQty= new ItemOrderQty(orderupdate.getOrder_id(),orderupdate.getItem_id(),orderupdate.getItem_quantity());
       ItemAmountResponse itemAmountResponse = webClient 
       .put()
       .uri("http://localhost:9191/updateOrderItem")
       .body(Mono.just(itemOrderQty), ItemOrderQty.class)
       .retrieve().bodyToMono(ItemAmountResponse.class).share().block();
      if(itemAmountResponse.getOrder_id()!=null){
        
        PaymentPriceUpdate paymentPriceUpdate= new PaymentPriceUpdate(
            itemAmountResponse.getOrder_id(),
            itemAmountResponse.getTotal_price(),
            orderupdate.getPaymentId()
        );

         String paymenString= webClient 
        .put()
        .uri("http://localhost:9192/updateOrderPaymentPrice")
        .body(Mono.just(paymentPriceUpdate), PaymentPriceUpdate.class)
        .retrieve().bodyToMono(String.class).share().block();


        Order order= new Order();
        order= orderservice.getOrderById(orderupdate.getOrder_id());
        order.setCostumer_id(orderupdate.getCostumer_id());
        order.setOrder_Status("Complete");
      //  order.setIsActive(true);
        order=orderservice.updateOrder(order);
        return paymenString;
    }

       return "Update Failed !!";
    }

    @PutMapping("/updateBulkOrders")
    public List<String> updateBulkOrder(@RequestBody List<OrderUpdate> orderupdates){
    
        List<String> paymentresponses= new ArrayList<>();

    for(OrderUpdate orderupdate: orderupdates){
  
      
        ItemOrderQty itemOrderQty= new ItemOrderQty(orderupdate.getOrder_id(),orderupdate.getItem_id(),orderupdate.getItem_quantity());
        ItemAmountResponse itemAmountResponse = webClient 
        .put()
        .uri("http://localhost:9191/updateOrderItem")
        .body(Mono.just(itemOrderQty), ItemOrderQty.class)
        .retrieve().bodyToMono(ItemAmountResponse.class).share().block();
       if(itemAmountResponse.getOrder_id()!=null){
         
         PaymentPriceUpdate paymentPriceUpdate= new PaymentPriceUpdate(
             itemAmountResponse.getOrder_id(),
             itemAmountResponse.getTotal_price(),
             orderupdate.getPaymentId()
         );
 
          String paymenString= webClient 
         .put()
         .uri("http://localhost:9192/updateOrderPaymentPrice")
         .body(Mono.just(paymentPriceUpdate), PaymentPriceUpdate.class)
         .retrieve().bodyToMono(String.class).share().block();
 
 
         Order order= new Order();
         order= orderservice.getOrderById(orderupdate.getOrder_id());
         order.setCostumer_id(orderupdate.getCostumer_id());
         order.setOrder_Status("Complete");
         order=orderservice.updateOrder(order);
         paymentresponses.add(paymenString)  ;
     }
        
    }
    return paymentresponses;
}
    
    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id){
        Order order= orderservice.getOrderById(id);
        order.setIsActive(0);
         orderservice.updateOrder(order);
         return "Deleted"+order.getCostumer_id();
    }

}
