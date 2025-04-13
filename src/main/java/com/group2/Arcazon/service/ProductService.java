package com.group2.Arcazon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.Arcazon.api.ProductDTO;
import com.group2.Arcazon.model.Category;
import com.group2.Arcazon.model.Product;
import com.group2.Arcazon.repository.CategoryRepository;
import com.group2.Arcazon.repository.ProductRepository;

@Service
public class ProductService {
     @Autowired
     private final ProductRepository productRepository;
     
     @Autowired
     private final CategoryRepository categoryRepository;
    
	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
	    this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
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
	
	/**
	 * Used for API calls. Allows creation of Product without creating category object in json.
	 * Simply send categoryId and all the product props
	 * @param productDTO
	 * @return
	 */
	public Product addNewProductUsingDTO(ProductDTO productDTO) {
		Category category = categoryRepository.findById(productDTO.getCategoryId())
				.orElseThrow(() -> new RuntimeException("Category with id: " + productDTO.getCategoryId() + " not found."));
		
		Product product = new Product(
				category, 
				productDTO.getName(), 
				productDTO.getDescription(), 
				productDTO.getPrice(), 
				productDTO.getStock());
		
		return productRepository.save(product);
	}
	
	public Product updateStock(Long productId, int newStock) {
	    Product product = getProductById(productId);
	    product.setStock(newStock);
	    return productRepository.save(product);
	}
}
