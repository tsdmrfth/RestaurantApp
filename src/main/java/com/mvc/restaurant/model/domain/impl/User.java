package com.mvc.restaurant.model.domain.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.mvc.restaurant.model.domain.AbstractEntity;

@Entity
@Table(name = "USERS", uniqueConstraints = @UniqueConstraint(columnNames = { "USERNAME" }))
public class User extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@Column(name = "USERNAME", length = 50, nullable = false)
	private String userName;
	@Column(name = "PASSWORD", length = 50, nullable = false)
	private String password;
	@Column(name = "USER_ROLE", nullable = false)
	private int userRole;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

}
