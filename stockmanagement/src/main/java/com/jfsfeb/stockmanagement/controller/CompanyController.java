package com.jfsfeb.stockmanagement.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jfsfeb.stockmanagement.dto.Company;
import com.jfsfeb.stockmanagement.dto.CompanyResponse;
import com.jfsfeb.stockmanagement.service.CompanyService;


@RestController
@CrossOrigin(origins ="*",allowedHeaders="*",allowCredentials ="true")
public class CompanyController {
	@Autowired
	CompanyService service;

	@PostMapping(path = "/add-company", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CompanyResponse addCompany(@RequestBody Company company) {
		CompanyResponse companyResponse = new CompanyResponse();
		if (service.addCompany(company)) {
			companyResponse.setStatusCode(201);
			companyResponse.setMessage("Success");
			companyResponse.setDescription("Successfully..Company details is added");
		} else {
			companyResponse.setStatusCode(401);
			companyResponse.setMessage("Failure");
			companyResponse.setDescription("Company is already exists");
		}
		return companyResponse;
	}

	@GetMapping(path = "/get-allcompanies", produces = MediaType.APPLICATION_JSON_VALUE)
	public CompanyResponse viewAllCompany() {
		CompanyResponse companyResponse = new CompanyResponse();
		List<Company> list = service.getAllCompanies();
		if (list.size() != 0) {
			companyResponse.setStatusCode(201);
			companyResponse.setMessage("Success");
			companyResponse.setDescription("Successfully found your companies");
			companyResponse.setCompany(list);
		} else {
			companyResponse.setStatusCode(401);
			companyResponse.setMessage("Failure");
			companyResponse.setDescription("No companies are found");
		}
		return companyResponse;
	}

	@GetMapping(path = "/search-company/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CompanyResponse viewCompany(@PathVariable("companyId") String companyId) {
		CompanyResponse companyResponse = new CompanyResponse();
		Company company = service.searchCompany(companyId);
		if (company != null) {
			companyResponse.setStatusCode(201);
			companyResponse.setMessage("Success");
			companyResponse.setDescription("Company is found");
			companyResponse.setCompany(Arrays.asList(company));
		} else {
			companyResponse.setStatusCode(401);
			companyResponse.setMessage("Failure");
			companyResponse.setDescription("This Company doesn't exist");
		}
		return companyResponse;
	}

	@DeleteMapping(path = "/delete-company/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CompanyResponse deleteCompany(@PathVariable("companyId") String companyId) {
		CompanyResponse companyResponse = new CompanyResponse();
		if (service.deleteCompany(companyId)) {
			companyResponse.setStatusCode(201);
			companyResponse.setMessage("Success");
			companyResponse.setDescription("Company details deleted");
		} else {
			companyResponse.setStatusCode(401);
			companyResponse.setMessage("Failure");
			companyResponse.setDescription("Company Details are not deleted");
		}
		return companyResponse;
	}

	@PutMapping(path = "/update-company/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CompanyResponse updateCompany(@PathVariable("companyId")String companyId, @RequestBody Company company) {
		CompanyResponse response = new CompanyResponse();
		if (service.updateCompany(companyId, company)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Company details are updated successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Company details are not updated");
		}
		return response;

	}
}