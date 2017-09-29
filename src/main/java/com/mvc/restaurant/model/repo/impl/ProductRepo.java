package com.mvc.restaurant.model.repo.impl;

import com.mvc.restaurant.model.domain.impl.Product;
import com.mvc.restaurant.model.repo.AbstractRepo;

public class ProductRepo extends AbstractRepo<Product> {

	public ProductRepo() {
		super(Product.class);
	}
}
