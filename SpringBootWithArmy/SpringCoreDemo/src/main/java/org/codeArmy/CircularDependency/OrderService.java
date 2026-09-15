//package org.codeArmy.CircularDependency;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class OrderService {
//
//    @Autowired
//    private PaymentService paymentService;
//
////    public OrderService( PaymentService paymentService) {
////        this.paymentService = paymentService;
////    }
//
//    public void placeOrder(){
//        paymentService.pay();
//        //avoiding Circular dependency
//        getOrderDetails();
//        System.out.println("Place Order...");
//    }
//
//    public void getOrderDetails(){
//        System.out.println("Order details Sent....");
//    }
//}
