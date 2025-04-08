package com.group2.Arcazon.repository;

import com.group2.Arcazon.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}