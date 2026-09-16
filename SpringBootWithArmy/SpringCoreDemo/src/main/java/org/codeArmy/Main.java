//package org.codeArmy;
//
//import org.codeArmy.BeanScope.Config.AppConfig;
//import org.codeArmy.BeanScope.OrderService;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class Main {
//    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        OrderService orderService = context.getBean(OrderService.class);
//        OrderService orderService1 = context.getBean(OrderService.class);
//        System.out.println(orderService1 == orderService);
//    }
//}

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