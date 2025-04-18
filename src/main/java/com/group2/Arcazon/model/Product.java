package com.group2.Arcazon.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "products")
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference				// Required to avoid infinite JSON returns
    private Category category;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int stock;

    public Product() {}
    
        
    /**
     * Constructs product with minimal data.
     * @param category
     * @param name
     * @param price
     */
    public Product(Category category, String name, BigDecimal price) {
		super();
		this.category = category;
		this.name = name;
		this.price = price;
	}

	/**
     * Constructs product with all possible data
     * @param category
     * @param name
     * @param description
     * @param price
     * @param stock
     */
    public Product(Category category, String name, String description, BigDecimal price, int stock) {
		super();
		this.category = category;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	// Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
