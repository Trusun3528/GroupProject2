package com.group2.Arcazon.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group2.Arcazon.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    List<Product> findByCategory_Id(Long categoryId);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
}