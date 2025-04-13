package com.group2.Arcazon.service;

import com.group2.Arcazon.model.Order;
import com.group2.Arcazon.model.OrderItem;
import com.group2.Arcazon.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByCustomer_Id(userId);
    }

    public List<Order> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return orderRepository.findByOrderDateBetween(startDate, endDate);
    }

    public List<Order> getOrdersByTotalGreaterThan(BigDecimal amount) {
        return orderRepository.findByTotalAmountGreaterThan(amount);
    }

    public BigDecimal calculateOrderTotal(List<OrderItem> items) {
        return items.stream()
                .map(item -> item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Order saveOrder(Order order) {
        BigDecimal total = calculateOrderTotal(order.getOrderItems());
        order.setTotalAmount(total);
        return orderRepository.save(order);
    }
}
