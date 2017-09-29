package com.mvc.restaurant.model.repo.impl;

import com.mvc.restaurant.model.domain.impl.Expense;
import com.mvc.restaurant.model.repo.AbstractRepo;

public class ExpenseRepo extends AbstractRepo<Expense> {

	public ExpenseRepo() {
		super(Expense.class);
	}
}
