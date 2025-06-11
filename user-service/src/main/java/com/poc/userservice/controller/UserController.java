package com.poc.userservice.controller;

import com.poc.userservice.client.OrderClient;
import com.poc.dto.OrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-service/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final OrderClient orderClient;

    public UserController(OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    @PostMapping("/{userId}/orders")
    public String createOrder(@PathVariable String userId, @RequestBody OrderRequest request) {
        logger.info("[user-service] Calling order-service to create order for userId={}", userId);
        return orderClient.createOrder(userId, request);
    }
}
