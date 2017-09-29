package com.mvc.restaurant.model.domain.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mvc.restaurant.model.domain.AbstractEntity;

@Entity
@Table(name = "PRODUCTS")
public class Product extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@Column(name = "NAME", length = 100, nullable = false)
	private String productName;
	@Column(name = "PRICE", nullable = false)
	private double price;
	@ManyToOne
	@JoinColumn(name = "PRODUCT_CATEGORY")
	private ProductCategory category;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

}
