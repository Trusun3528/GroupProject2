package com.group2.Arcazon.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group2.Arcazon.api.ProductDTO;
import com.group2.Arcazon.model.Category;
import com.group2.Arcazon.model.Product;
import com.group2.Arcazon.service.CategoryService;
import com.group2.Arcazon.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	// Gets all products in db using "/products"
	@GetMapping
	public String getAllProducts(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "products";
		
	}
	
	@GetMapping("/{id}")
	public String getProductById(@PathVariable Long id, Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "product-details";
	}
	
	@GetMapping("/add")
	public String getAddProduct(Model model) {
		// make product obj and add attribute
		model.addAttribute("product", new Product());
		
		// Get all ye categories to put in them chest fer ye scallywags
		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);
		return "add-product";
	}
	
	// Create a product
	@PostMapping("/add")
	public String addProduct(Product product) {
		productService.addNewProduct(product);
		return "redirect:/products";
	}
	
	// Get to edit page
	@GetMapping("/edit/{id}")
	public String getEditProduct(@PathVariable Long id, Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		
		// Get all ye categories to put in them chest fer ye scallywags
		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);
		
		return "edit-product";
	}
	
	// PUT /products/{id} - update an existing product
	@PostMapping("/edit")
	public String editProduct(Product product) {
		productService.saveProduct(product);
		return "redirect:/products";
	}
	
	
	// DELETE /product/{id} - delete an existing product
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		return "redirect:/products";
	}
}
