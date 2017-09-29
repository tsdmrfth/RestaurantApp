package com.mvc.restaurant.model.domain.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mvc.restaurant.model.domain.AbstractEntity;

@Entity
@Table(name = "EXPENSES")
public class Expense extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@Column(name = "DESCRIPTION", length = 250, nullable = false)
	private String desctription;
	@Column(name = "EXPENDITURE_DATE", nullable = false)
	private Date expenditureDate;
	@Column(name = "AMOUNT", nullable = false)
	private Double spendingAmount;

	public String getDesctription() {
		return desctription;
	}

	public void setDesctription(String desctription) {
		this.desctription = desctription;
	}

	public Date getExpenditureDate() {
		return expenditureDate;
	}

	public void setExpenditureDate(Date expenditureDate) {
		this.expenditureDate = expenditureDate;
	}

	public Double getSpendingAmount() {
		return spendingAmount;
	}

	public void setSpendingAmount(Double spendingAmount) {
		this.spendingAmount = spendingAmount;
	}

}
