// This class exists to make creating Products through API calls as simple as possible
// I didn't want to have the api require ridiculous JSONs with full category and product objects
// Some guys on Stack Overflow said this was the way so I blame them.

package com.group2.Arcazon.api;

import java.math.BigDecimal;

public class ProductDTO {

	private Long categoryId;
	private String name;
	private String description;
	private BigDecimal price;
	private int stock;
	
	// Ye Old Getters and Setters
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
