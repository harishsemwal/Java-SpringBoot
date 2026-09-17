package org.codeArmy;

import org.codeArmy.BeanInitialisationDemo.Config.AppConfig;
import org.codeArmy.BeanInitialisationDemo.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        System.out.println("Payment Service Not started yet...");
        orderService.placeOrder();
//        PaymentService paymentService = context.getBean(PaymentService.class);
    }
}

/*

Bean Scope: Singleton
            Prototype
            Request -: HTTP Request
            Session -: session
            Application -: whole application single object.

 */

/*
Singleton -: Eager initialization - stateless.
Prototype -: Lazy initialization - state full.
 */


/*
spring.main.lazy-initialization=true
why spring boot think @lazy Initialisation?



 */