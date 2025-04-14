package com.group2.Arcazon.api;

import com.group2.Arcazon.model.Order;
import com.group2.Arcazon.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout(@RequestBody OrderRequestDTO orderRequest) {
        Order order = orderService.createOrder(orderRequest.getCustomerId(), orderRequest.getItems());
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}

