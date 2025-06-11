package com.poc.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "notification-service")
public interface NotificationClient {
    @PostMapping("/notification-service/notifications/send")
    String sendNotification(@RequestParam String userId, @RequestParam String message);
}
