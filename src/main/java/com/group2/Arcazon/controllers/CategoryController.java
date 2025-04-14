package com.group2.Arcazon.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group2.Arcazon.model.Category;
import com.group2.Arcazon.model.Product;
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
	
	@GetMapping("/edit/{id}")
	public String getEditCategory(@PathVariable Long id, Model model) {
		
		Category category = categoryService.getCategoryById(id)
				.orElseThrow(() -> new RuntimeException("Category: " + id + " not found."));
		model.addAttribute("category", category);
		
		return "edit-category";
	}
	
	@PostMapping("/edit")
	public String editCategory(Category category) {
		categoryService.saveCategory(category);
		return "redirect:/categories";
	}
	
	@GetMapping("/add")
	public String getAddCategory(Model model) {
		// make category obj and add attribute
		model.addAttribute("category", new Category());
		
		return "add-category";
	}
	
	// Create a product
	@PostMapping("/add")
	public String addCategory(Category category) {
		categoryService.saveCategory(category);
		return "redirect:/categories";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategoryById(id);
		return "redirect:/categories";
	}
	
}
