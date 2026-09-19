package org.codeArmy;

import org.codeArmy.BeansLifeCycle.CartService;
import org.codeArmy.BeansLifeCycle.Config.AppConfig;
import org.codeArmy.BeansLifeCycle.OrderService;
import org.codeArmy.CircularDependency.simple.A;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConfigurableApplicationContext configurableApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        OrderService orderService = context.getBean(OrderService.class);
//        orderService.placeOrder();

//        CartService cartService = configurableApplicationContext.getBean(CartService.class);
//        cartService.addToCart();
//        System.out.println(cartService.getValue(1));
//
//        configurableApplicationContext.close();

        A a = new A();
    }
}
