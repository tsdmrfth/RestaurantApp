package com.mvc.restaurant.model.repo.impl;

import com.mvc.restaurant.model.domain.impl.User;
import com.mvc.restaurant.model.repo.AbstractRepo;

public class UserRepo extends AbstractRepo<User> {

	public UserRepo() {
		super(User.class);
	}
}
