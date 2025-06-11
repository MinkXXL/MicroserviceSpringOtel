package com.poc.orderservice.controller;

import com.poc.orderservice.client.NotificationClient;
import com.poc.dto.OrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order-service/orders")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private final NotificationClient notificationClient;

    public OrderController(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    @PostMapping("createOrder")
    public String createOrder(@RequestParam String userId, @RequestBody OrderRequest request) {
        logger.info("[order-service] Creating order and calling notification-service for userId={}", userId);
        notificationClient.sendNotification(userId, "Your order has been placed.");
        return "Order created for " + userId;
    }
}
