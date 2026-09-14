package org.codeArmy.Service;

import org.codeArmy.Service.NotificationServiceImpl.EmailService;

public class OrderService {
    private Notification notification;

//    public OrderService(Notification notification){
//        this.notification = notification;
//    }

    public void placeOrder() {
        System.out.print("Order Place...");
        notification.sendNotification();
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
