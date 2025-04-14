package com.group2.Arcazon.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group2.Arcazon.model.Category;
import com.group2.Arcazon.service.CategoryService;
import com.group2.Arcazon.service.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	private final CategoryService categoryService;
	private final ProductService productService;

	public CategoryController(ProductService productService, CategoryService categoryService) {
		this.categoryService = categoryService;
		this.productService = productService;
		
	}
	
	@GetMapping
	public String getAllCategories(Model model) {
		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);
		return "categories";
		
	}
	
}
