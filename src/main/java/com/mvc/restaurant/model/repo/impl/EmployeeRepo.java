package com.mvc.restaurant.model.repo.impl;

import com.mvc.restaurant.model.domain.impl.Employee;
import com.mvc.restaurant.model.repo.AbstractRepo;

public class EmployeeRepo extends AbstractRepo<Employee> {

	public EmployeeRepo() {
		super(Employee.class);
	}

}
