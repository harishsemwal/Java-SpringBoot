package org.codeArmy.SpringXMLConfiguration;

import org.codeArmy.SpringXMLConfiguration.payment.PaymentService;

public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("OrderService Created");
    }

    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order Placed...");
    }
//
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
}
