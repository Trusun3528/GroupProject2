package com.group2.Arcazon.service;

import com.group2.Arcazon.api.OrderItemDTO;
import com.group2.Arcazon.model.Order;
import com.group2.Arcazon.model.OrderItem;
import com.group2.Arcazon.model.OrderItemId;
import com.group2.Arcazon.model.Product;
import com.group2.Arcazon.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

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
    
    public Order createOrder(Long customerId, List<OrderItemDTO> items) {
        Order order = new Order();
        order.setCustomer(customerService.getCustomerById(customerId));
        order.setOrderDate(LocalDateTime.now());

        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (OrderItemDTO dto : items) {
            Product product = productService.getProductById(dto.getProductId());
            BigDecimal unitPrice = product.getPrice();

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(dto.getQuantity());
            orderItem.setUnitPrice(unitPrice);

            OrderItemId itemId = new OrderItemId();
            orderItem.setId(itemId);

            orderItems.add(orderItem);

            total = total.add(unitPrice.multiply(BigDecimal.valueOf(dto.getQuantity())));
        }

        order.setOrderItems(orderItems);
        order.setTotalAmount(total);

        return orderRepository.save(order);
    }
}
