package com.mvc.restaurant.model.repo.impl;

import com.mvc.restaurant.model.domain.impl.Order;
import com.mvc.restaurant.model.repo.AbstractRepo;

public class OrderRepo extends AbstractRepo<Order> {

	public OrderRepo() {
		super(Order.class);
	}

}
