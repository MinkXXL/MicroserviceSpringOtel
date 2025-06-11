package com.poc.notificationservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification-service/notifications")
public class NotificationController {

    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @PostMapping("/send")
    public String send(@RequestParam String userId, @RequestParam String message) {
        logger.info("[notification-service] Sending notification to userId={}, message=\"{}\"", userId, message);
        return "Notification sent to " + userId;
    }
}
