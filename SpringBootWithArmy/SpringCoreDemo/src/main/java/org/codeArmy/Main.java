package org.codeArmy;

import org.codeArmy.CircularDependency.Config.AppConfig;
import org.codeArmy.CircularDependency.OrderService;
import org.codeArmy.CircularDependency.simple.A;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder();

//        A a = new A(); --: Circular Dependency

    }
}