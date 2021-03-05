package com.capgemini.stockmanagement.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jfsfeb.stockmanagement.dao.CompanyDAO;
import com.jfsfeb.stockmanagement.dto.Company;

import junit.framework.TestCase;

@SpringBootTest
class CompanyDAOTest {

	@Autowired
	private CompanyDAO dao;
	private Company company = new Company();

	@Test
	void testAddCompany() {
		try {
			Company company = new Company();
			company.setCompanyName("CapGemini");
			company.setTotalQuantity(10000);
			company.setStockAvailability(5000);
			boolean result = dao.addCompany(company);
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				dao.addCompany(company);
			});
		}
	}

	@Test
	void testDeleteCompany() {
		try {
			Company company = new Company();
			company.setCompanyId("2");
			boolean result = dao.deleteCompany(company.getCompanyId());
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				dao.addCompany(company);
			});
		}
	}

	@Test
	void testUpdateCompany() {
		try {
			Company company = new Company();
			company.setCompanyId("1");
			company.setTotalQuantity(18000);
			boolean result = dao.updateCompany(company.getCompanyId(), company);
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				dao.addCompany(company);
			});
		}
	}

	@Test
	void testGetAllCompanies() {
		List<Company> companies = dao.getAllCompanies();
		TestCase.assertNotNull(companies);
	}

//	@Test
//	void testSearchCompany() {
//		try {
//			Company company = new Company();
//			company.setCompanyName("CapGemini");
//			Company company1 = dao.searchCompany(company.getCompanyName());
//			assertNotNull(company1);
//		} catch (Exception e) {
//			assertThrows(Exception.class, () -> {
//				dao.addCompany(company);
//			});
//		}

}
