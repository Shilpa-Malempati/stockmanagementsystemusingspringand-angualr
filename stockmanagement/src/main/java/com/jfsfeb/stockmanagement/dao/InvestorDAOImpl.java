package com.jfsfeb.stockmanagement.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jfsfeb.stockmanagement.dto.Company;
import com.jfsfeb.stockmanagement.dto.InvestorRequestObject;
import com.jfsfeb.stockmanagement.dto.InvestorShare;
import com.jfsfeb.stockmanagement.dto.Stock;

@Repository
public class InvestorDAOImpl implements InvestorDAO{
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public boolean addShare(InvestorRequestObject investor) {
		boolean isAdded = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		InvestorShare record = new InvestorShare();
		record.setCompanyId(investor.getCompanyId());
		record.setUserId(investor.getUserId());
		record.setAvailableAmount(investor.getTotalAmount());
		record.setTotalSharesBought(investor.getTotalSharesTransacted());
		record.setTotalAmountBought(investor.getTotalAmount());
		record.setAvailableShares(investor.getTotalSharesTransacted());
//		record.setTotalSharesSold(0);
//		record.setTotalAmountSold(0);
		try {
			transaction.begin();
			manager.persist(record);
			transaction.commit();
			isAdded = true;
			updateStockAvailability(investor, true);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public boolean updateStockAvailability(InvestorRequestObject investor, boolean flag) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			Company bean = manager.find(Company.class, investor.getCompanyId());
			if (bean != null) {
				transaction.begin();
				if(flag) {
					bean.setStockAvailability(bean.getStockAvailability() - investor.getTotalSharesTransacted());					
				} else {
					bean.setStockAvailability(bean.getStockAvailability() + investor.getTotalSharesTransacted());
				}
				isUpdated = true;
				transaction.commit();
				
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
	public List<InvestorShare> getAllShares(int id) {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql = "from InvestorShare i where i.userId=:id1";
			TypedQuery<InvestorShare> query = manager.createQuery(jpql, InvestorShare.class);
			query.setParameter("id1", id);
			return query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

}

