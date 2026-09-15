//package org.codeArmy.Random;
//
//import org.codeArmy.CartService;
//import org.codeArmy.OrderService;
//import org.codeArmy.Payment.CardlessPaymentService;
//import org.codeArmy.Payment.PaymentService;
//import org.codeArmy.Payment.UpiPaymentService;
//import org.codeArmy.User;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@ComponentScan("org.codeArmy")
//public class AppConfig {
//
//    @Bean
//    public User createUser() {
//        return new User("H21", "Harish");
//    }
//
//    @Bean
//    public CartService createCartService() {
//        return new CartService();
//    }
//
//    @Bean
//    @Qualifier("card")
//    public PaymentService createCardPayment() {
//        return new CardlessPaymentService();
//    }
//
//    @Bean
//    @Qualifier("upi")
//    public PaymentService createUpiPayment() {
//        return new UpiPaymentService();
//    }
//
//    @Bean
//    public OrderService createOrder(@Qualifier("upi") PaymentService paymentService) {
//
//        return new OrderService(paymentService);
//    }
//}
