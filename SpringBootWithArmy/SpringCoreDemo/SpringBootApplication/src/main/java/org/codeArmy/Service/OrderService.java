package org.codeArmy.Service;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService paymentService;


    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("Order Service Created");
    }

    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order placed");
    }
}
