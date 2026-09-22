package org.codeArmy;

import org.codeArmy.SpringXMLConfiguration.OrderService;
import org.codeArmy.SpringXMLConfiguration.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        OrderService orderService = (OrderService) context.getBean("orderServiceBean", OrderService.class);
//        orderService.placeOrder();

//        PaymentService paymentService = (PaymentService) context.getBean("paymentService", PaymentService.class);
//        paymentService.pay();

        UserService userService = context.getBean("userService", UserService.class);
//        System.out.println(userService.getUsernames());
        context.close();
    }
}
