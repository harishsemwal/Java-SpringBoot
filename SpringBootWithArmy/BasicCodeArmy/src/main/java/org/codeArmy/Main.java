package org.codeArmy;

import org.codeArmy.Service.Notification;
import org.codeArmy.Service.NotificationServiceImpl.EmailService;
import org.codeArmy.Service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Notification notification = new EmailService();
        OrderService orderService = new OrderService();
//        OrderService orderService = new OrderService();
        orderService.setNotification(notification);
        orderService.placeOrder();
    }
}