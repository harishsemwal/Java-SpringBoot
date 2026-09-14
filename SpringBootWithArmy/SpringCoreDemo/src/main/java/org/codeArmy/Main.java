package org.codeArmy;

import org.codeArmy.Random.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        User user = context.getBean(User.class);
//        System.out.println(user.getUserId() + " " + user.getUserName());
//
//        CartService cart = context.getBean(CartService.class);
//        cart.addToCart();

        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder();

    }
}