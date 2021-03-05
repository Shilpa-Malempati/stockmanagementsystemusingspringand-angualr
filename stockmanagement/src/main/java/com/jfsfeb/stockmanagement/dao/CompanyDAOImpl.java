package com.jfsfeb.stockmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jfsfeb.stockmanagement.dto.Company;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean updateCompany(String companyId, Company company) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			Company bean = manager.find(Company.class, companyId);
			if (bean != null) {
				transaction.begin();
				//bean.setStockAvailability(company.getStockAvailability());
				bean.setTotalQuantity(company.getTotalQuantity());
				bean.setBidPrice(company.getBidPrice());
				bean.setMaxStockAmount(company.getMaxStockAmount());
				bean.setMaxStockQuantity(company.getMaxStockAmount());
				transaction.commit();
				isUpdated = true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isUpdated;
	}

	@Override
	public List<Company> getAllCompanies() {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql = "from Company";
			TypedQuery<Company> query = manager.createQuery(jpql, Company.class);
			return query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public Company getCompany(String companyId) {
		EntityManager manager = factory.createEntityManager();
		try {
			Company bean = manager.find(Company.class, companyId);
			return bean;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public boolean deleteCompany(String companyId) {
		boolean isDeleted = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Company company = manager.find(Company.class, companyId);
		if (company != null) {
			try {
				transaction.begin();
				manager.remove(company);
				transaction.commit();
				isDeleted = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				transaction.rollback();
			} finally {
				manager.close();
			}
		}
		return isDeleted;
	}

	@Override
	public boolean addCompany(Company company) {
		boolean isAdded = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(company);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isAdded;
	}

}