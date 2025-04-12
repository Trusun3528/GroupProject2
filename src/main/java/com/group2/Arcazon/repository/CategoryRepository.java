package com.group2.Arcazon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group2.Arcazon.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByNameContainingIgnoreCase(String name);
}