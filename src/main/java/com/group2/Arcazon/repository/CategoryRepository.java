package com.group2.Arcazon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group2.Arcazon.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Category save(Category category);
    List<Category> findByNameContainingIgnoreCase(String name);
}