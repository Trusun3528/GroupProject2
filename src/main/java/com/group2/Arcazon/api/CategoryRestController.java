package com.group2.Arcazon.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group2.Arcazon.model.Category;
import com.group2.Arcazon.service.CategoryService;


@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

	private final CategoryService categoryService;
	
	
	public CategoryRestController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public List<Category> getAllCategories(){
		return categoryService.getAllCategories();
	}
	
	@GetMapping("/{id}")
	public Optional<Category> getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}
	
	
	
}
