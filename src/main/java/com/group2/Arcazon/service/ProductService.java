package com.group2.Arcazon.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.Arcazon.model.Product;
import com.group2.Arcazon.repository.ProductRepository;

@Service
public class ProductService {
     @Autowired
    private ProductRepository productRepository;
    
    public Product addNewProduct(Product product) {
        
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        
        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Product price must be greater than zero");
        }
        
        
        return productRepository.save(product);
    }
    
    public Product updateStock(Long productId, int quantity) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            
            if (product.getStock() + quantity < 0) {
                throw new IllegalArgumentException("Cannot reduce stock below zero");
            }
            
            product.setStock(product.getStock() + quantity);
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found with id: " + productId);
        }
    }
    
}
