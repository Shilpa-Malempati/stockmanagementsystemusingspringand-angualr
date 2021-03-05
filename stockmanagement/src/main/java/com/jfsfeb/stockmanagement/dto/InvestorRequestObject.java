package com.jfsfeb.stockmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "investorrequest_info")
public class InvestorRequestObject {
	@Id
	@Column
	private int userId;
	@Column(nullable = false)
	private String companyId;
	@Column(nullable = false)
	private double totalAmount;
	@Column(nullable = false)
	private int totalSharesTransacted;
	
}
