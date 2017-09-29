package com.mvc.restaurant.model.repo.impl;

import com.mvc.restaurant.model.domain.impl.ProductCategory;
import com.mvc.restaurant.model.repo.AbstractRepo;

public class ProductCategoryRepo extends AbstractRepo<ProductCategory> {

	public ProductCategoryRepo() {
		super(ProductCategory.class);
	}
}
