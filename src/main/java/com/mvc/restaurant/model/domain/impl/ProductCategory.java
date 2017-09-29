package com.mvc.restaurant.model.domain.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mvc.restaurant.model.domain.AbstractEntity;

@Entity
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategory extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@Column(name = "NAME")
	private String categoryName;
	@OneToMany(mappedBy = "category")
	private List<Product> productList = new ArrayList<>();

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
