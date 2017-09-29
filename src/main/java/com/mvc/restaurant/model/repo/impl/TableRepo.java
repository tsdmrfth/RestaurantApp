package com.mvc.restaurant.model.repo.impl;

import com.mvc.restaurant.model.domain.impl.RestaurantTable;
import com.mvc.restaurant.model.repo.AbstractRepo;

public class TableRepo extends AbstractRepo<RestaurantTable> {

	public TableRepo() {
		super(RestaurantTable.class);
	}
}
