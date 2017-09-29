package com.mvc.restaurant.model.domain.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mvc.restaurant.model.domain.AbstractEntity;

@Entity
@Table(name = "TABLES")
public class RestaurantTable extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@Column(name = "TABLE_NAME", length = 50, nullable = false)
	private String tableName;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
