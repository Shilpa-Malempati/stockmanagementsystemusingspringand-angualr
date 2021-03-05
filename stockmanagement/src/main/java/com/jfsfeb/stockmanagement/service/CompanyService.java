package com.jfsfeb.stockmanagement.service;

import java.util.List;

import com.jfsfeb.stockmanagement.dto.Company;

public interface CompanyService {
	boolean addCompany(Company company);

	boolean deleteCompany(String companyId);

	boolean updateCompany(String companyId, Company company);

	List<Company> getAllCompanies();

	Company searchCompany(String companyId);
}
