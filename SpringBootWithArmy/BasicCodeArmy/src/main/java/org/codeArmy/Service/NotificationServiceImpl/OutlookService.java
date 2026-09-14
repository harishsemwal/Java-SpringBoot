package org.codeArmy.Service.NotificationServiceImpl;

import org.codeArmy.Service.Notification;

public class OutlookService  implements Notification {
    @Override
    public void sendNotification() {
        System.out.print("Outlook Notification Sent..");
    }
}
