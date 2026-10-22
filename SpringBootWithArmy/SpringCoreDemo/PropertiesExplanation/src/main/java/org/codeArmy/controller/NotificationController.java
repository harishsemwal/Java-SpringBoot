package org.codeArmy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notification")
public class NotificationController {

    @PostMapping
    public ResponseEntity<String> sendNotification(){
        return ResponseEntity.ok("Notification Sent...");
    }
}
