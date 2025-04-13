package com.group2.Arcazon.api;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group2.Arcazon.model.Product;
import com.group2.Arcazon.service.ProductService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

	private final ProductService productService;
	
	@PostConstruct
	public void init() {
	    System.out.println("ProductRestController loaded.");
	}
	
	public ProductRestController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id){
		return productService.getProductById(id);
		
		 
	}
	
	@GetMapping("price-range/{minPrice}/{maxPrice}")
	public List<Product> findByPriceBetween(@PathVariable BigDecimal minPrice, @PathVariable java.math.BigDecimal maxPrice){
		return productService.findByPriceBetween(minPrice, maxPrice);
	}
	
	// Get /product/{id} - get an individual product
	/*
	@GetMapping("/{id}")
	public String getProductById(@PathVariable Long id, Model model) {
		Product product = productService.findById(id);
		model.addAttribute("products", product);
		return "product-details"; // maps to a product-details.html page
	}
	*/
}
