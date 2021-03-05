package com.jfsfeb.stockmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "stocks_info")
public class Stock {
	@Id
	@Column
	@GeneratedValue
	private int stockId;
	@Column(nullable=false)
	private String price;
	@Column(nullable=false)
	private String stockQuantity;
	@Column(nullable=false)
	private String companyId;
}