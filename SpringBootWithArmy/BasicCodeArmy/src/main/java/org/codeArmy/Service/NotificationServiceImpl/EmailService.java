package org.codeArmy.Service.NotificationServiceImpl;

import org.codeArmy.Service.Notification;

public class EmailService implements Notification {
    @Override
    public void sendNotification() {
        System.out.print("Email Notification Sent..");
    }
}
