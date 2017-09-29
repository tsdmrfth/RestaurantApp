package com.mvc.restaurant.model.domain.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mvc.restaurant.model.domain.AbstractEntity;

@Entity
@Table(name = "ORDERS")
public class Order extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@Column(name = "COST", nullable = false)
	private Integer cost;
	@ElementCollection
	private List<String> orderList;
	@Column(name = "TABLE_ID", nullable = false)
	private Integer tableID;
	@Column(name = "ORDER_DATE", nullable = false)
	private Date orderDate;
	@Column(name = "IS_PAID")
	private boolean isPaid = false;

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public List<String> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<String> orderList) {
		this.orderList = orderList;
	}

	public Integer getTableID() {
		return tableID;
	}

	public void setTableID(Integer tableID) {
		this.tableID = tableID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

}
