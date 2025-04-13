package com.group2.Arcazon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.Arcazon.model.Product;
import com.group2.Arcazon.repository.ProductRepository;

@Service
public class ProductService {
     @Autowired
    private final ProductRepository productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public List<Product> findByPriceBetween(java.math.BigDecimal minPrice, java.math.BigDecimal maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }
    public List<Product> findByCategory_Id(Long categoryId) {
        return productRepository.findByCategory_Id(categoryId);
    }
    //distinguishes between new and existing products
    public Product addNewProduct(Product product) {
        if (product.getId() != null && productRepository.existsById(product.getId())) {
            throw new RuntimeException("Product already exists with ID: " + product.getId());
        }
        return productRepository.save(product);
    }
    public Product updateStock(Long productId, int newStock) {
        Product product = getProductById(productId);
        product.setStock(newStock);
        return productRepository.save(product);
    }
}
