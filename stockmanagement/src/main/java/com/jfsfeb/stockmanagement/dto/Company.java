package com.jfsfeb.stockmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "companies_info")
public class Company {
	@Id
	@Column
	private String companyId;
	@Column(nullable = false,unique=true)
	private String companyName;
	@Column(nullable = false)
	private int stockAvailability;
	@Column(nullable = false)
	private int totalQuantity;
	@Column(nullable=false)
	private double bidPrice;
	@Column(nullable = false)
	private int maxStockAmount;
	@Column(nullable=false)
	private int maxStockQuantity;

}
