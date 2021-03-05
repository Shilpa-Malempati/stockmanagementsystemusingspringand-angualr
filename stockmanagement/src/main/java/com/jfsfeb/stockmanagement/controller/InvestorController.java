package com.jfsfeb.stockmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jfsfeb.stockmanagement.dto.InvestorRequestObject;
import com.jfsfeb.stockmanagement.dto.InvestorResponse;
import com.jfsfeb.stockmanagement.dto.InvestorShare;
import com.jfsfeb.stockmanagement.dto.Stock;
import com.jfsfeb.stockmanagement.dto.StockResponse;
import com.jfsfeb.stockmanagement.service.InvestorService;

@RestController
@CrossOrigin(origins ="*",allowedHeaders="*",allowCredentials ="true")
public class InvestorController {
	@Autowired
	InvestorService service;

	@PostMapping(path = "/add-share", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public InvestorResponse addShare(@RequestBody InvestorRequestObject investor) {
		InvestorResponse investorResponse = new InvestorResponse();
		if (service.addShare(investor)) {
			investorResponse.setStatusCode(201);
			investorResponse.setMessage("Success");
			investorResponse.setDescription("Successfully... Shares are bought..");
		} else {
			investorResponse.setStatusCode(401);
			investorResponse.setMessage("Failure");
			investorResponse.setDescription("Something went wrong in buying shares.....");
		}
		return investorResponse;
	}

    @GetMapping(path = "/get-allshares/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public InvestorResponse getAllShares(@PathVariable("userId") int id) {
	       InvestorResponse response = new InvestorResponse();
		List<InvestorShare> shareDetails = service.getAllShares(id);
		if (shareDetails.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("You got all the Shares details");
			response.setShareDetails(shareDetails);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data is present");
		}
		return response;

	}

	
}

