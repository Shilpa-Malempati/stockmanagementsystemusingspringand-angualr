package com.jfsfeb.stockmanagement.service;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsfeb.stockmanagement.dao.CompanyDAO;
import com.jfsfeb.stockmanagement.dto.Company;
import com.jfsfeb.stockmanagement.exception.ValidationException;
import com.jfsfeb.stockmanagement.util.Validation;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDAO dao;

	@Override
	public boolean addCompany(Company company) {
		Validation v = new Validation();
		String companyName = company.getCompanyName();
		if(v.nameValidation(companyName)) {
			company.setCompanyName(companyName);
		}else{
			throw new ValidationException("Enter only alphabet in name field");
		}
		String companyId = company.getCompanyId();
		if(v.companyIdValidation(companyId)) {
			company.setCompanyId(companyId);
		}
		else {
			throw new ValidationException("Enter id in this format (example :TS-01)");
		}
		return dao.addCompany(company);
	}

	@Override
	public boolean deleteCompany(String companyId) {

		return dao.deleteCompany(companyId);
	}

	@Override
	public boolean updateCompany(String companyId, Company company) {
		Validation v = new Validation();
		String companyName = company.getCompanyName();
		if(v.nameValidation(companyName)) {
			company.setCompanyName(companyName);
		}else{
			throw new ValidationException("Enter only alphabet in name field");
		}
		companyId = company.getCompanyId();
		if(v.companyIdValidation(companyId)) {
			company.setCompanyId(companyId);
		}
		else {
			throw new ValidationException("Enter id in this format (example :TS-01)");
		}
		return dao.updateCompany(companyId, company);
	}

	@Override
	public List<Company> getAllCompanies() {

		return dao.getAllCompanies();
	}

	@Override
	public Company searchCompany(String companyId) {

		return dao.getCompany(companyId);
	}

}