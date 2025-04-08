package com.group2.Arcazon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.Arcazon.repository.OrderRepository;
import com.group2.Arcazon.repository.ProductRepository;

@Service
public class OrderService {
@Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductService productService;
    
}
