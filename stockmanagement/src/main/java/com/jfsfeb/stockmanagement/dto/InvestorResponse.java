package com.jfsfeb.stockmanagement.dto;

import java.util.List;

import lombok.Data;
@Data
public class InvestorResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<InvestorShare> shareDetails;
	
}
