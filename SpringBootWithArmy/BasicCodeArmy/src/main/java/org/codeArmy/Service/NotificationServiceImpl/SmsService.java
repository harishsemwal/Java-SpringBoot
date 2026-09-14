package org.codeArmy.Service.NotificationServiceImpl;

import org.codeArmy.Service.Notification;

public class SmsService implements Notification {
    @Override
    public void sendNotification() {
        System.out.print("SMS Notification Sent..");
    }
}
