package com.group2.Arcazon.controllers;

import com.group2.Arcazon.api.OrderDTO;
import com.group2.Arcazon.api.OrderItemDTO;
import com.group2.Arcazon.api.OrderRequestDTO;
import com.group2.Arcazon.model.Order;
import com.group2.Arcazon.model.Product;
import com.group2.Arcazon.service.CustomerService;
import com.group2.Arcazon.service.OrderService;
import com.group2.Arcazon.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/checkout")
    public String showCheckoutForm(Model model) {
        OrderDTO orderDTO = new OrderDTO();
        List<Product> products = productService.getAllProducts();

        for (Product product : products) {
            OrderItemDTO item = new OrderItemDTO();
            item.setProductId(product.getId());
            orderDTO.getItems().add(item);
        }

        model.addAttribute("products", products);
        model.addAttribute("orderRequest", orderDTO);
        return "checkout";
    }

    @PostMapping("/checkout")
    public String processCheckout(@ModelAttribute OrderRequestDTO orderRequest, Model model) {
        // Filter out items that weren't purchased
        List<OrderItemDTO> filteredItems = orderRequest.getItems().stream()
            .filter(item -> item.getQuantity() > 0)
            .toList();

        Order savedOrder = orderService.createOrder(orderRequest.getCustomerId(), filteredItems);

        model.addAttribute("order", savedOrder);
        return "order-confirmation";
    }

}
