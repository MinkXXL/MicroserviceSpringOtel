package com.poc.userservice.client;

import com.poc.dto.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "order-service")
public interface OrderClient {
    @PostMapping("/order-service/orders/createOrder")
    String createOrder(@RequestParam String userId, @RequestBody OrderRequest request);
}
