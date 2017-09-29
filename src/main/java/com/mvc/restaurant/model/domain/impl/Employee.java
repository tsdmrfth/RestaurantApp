package com.mvc.restaurant.model.domain.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mvc.restaurant.model.domain.AbstractEntity;

@Entity
@Table(name = "EMPLOYEES")
public class Employee extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String lastName;
	@Column(name = "SALARY", nullable = false)
	private double salary;
	@Column(name = "HIRE_DATE", nullable = false)
	private Date hireDate;
	@Column(name = "PHONE_NUMBER", length = 20, nullable = false)
	private String phoneNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
