package org.codeArmy.Service.NotificationServiceImpl;

import org.codeArmy.Service.Notification;

public class FakeEmailService  implements Notification {
    @Override
    public void sendNotification() {
        System.out.print("Fake News Notification Sent..");
    }
}
