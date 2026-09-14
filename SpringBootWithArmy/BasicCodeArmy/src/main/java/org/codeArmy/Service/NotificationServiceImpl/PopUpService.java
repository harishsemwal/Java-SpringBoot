package org.codeArmy.Service.NotificationServiceImpl;

import org.codeArmy.Service.Notification;

public class PopUpService  implements Notification {
    @Override
    public void sendNotification() {
        System.out.print("Pop Up Notification Sent..");
    }
}
