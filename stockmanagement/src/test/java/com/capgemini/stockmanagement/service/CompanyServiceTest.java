//package com.capgemini.stockmanagement.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.capgemini.stockmanagement.dto.Company;
//
//import junit.framework.TestCase;
//
//@SpringBootTest
//class CompanyServiceTest {
//
//	@Autowired
//	private CompanyService service;
//	private Company company = new Company();
//
//	@Test
//	void testAddCompany() {
//		try {
//			Company company = new Company();
//			company.setCompanyName("CapGemini");
//			company.setQuantity("10000");
//			company.setStockAvailability("5000");
//			boolean result = service.addCompany(company);
//			assertEquals(result, true);
//		} catch (Exception e) {
//			assertThrows(Exception.class, () -> {
//				service.addCompany(company);
//			});
//		}
//	}
//
//	@Test
//	void testDeleteCompany() {
//		try {
//			Company company = new Company();
//			company.setCompanyId(2);
//			boolean result = service.deleteCompany(company.getCompanyId());
//			assertEquals(result, true);
//		} catch (Exception e) {
//			assertThrows(Exception.class, () -> {
//				service.addCompany(company);
//			});
//		}
//	}
//
//	@Test
//	void testUpdateCompany() {
//		try {
//			Company company = new Company();
//			company.setCompanyId(1);
//			company.setQuantity("18000");
//			boolean result = service.updateCompany(company.getCompanyId(), company);
//			assertEquals(result, true);
//		} catch (Exception e) {
//			assertThrows(Exception.class, () -> {
//				service.addCompany(company);
//			});
//		}
//	}
//
//	@Test
//	void testGetAllCompanies() {
//		List<Company> companies = service.getAllCompanies();
//		TestCase.assertNotNull(companies);
//	}
//
////	@Test
////	void testSearchCompany() {
////		try {
////			Company company = new Company();
////			company.setCompanyName("CapGemini");
////			Company company1 = service.searchCompany(company.getCompanyName());
////			assertNotNull(company1);
////		} catch (Exception e) {
////			assertThrows(Exception.class, () -> {
////				service.addCompany(company);
////			});
////		}
////	}
//
//}
