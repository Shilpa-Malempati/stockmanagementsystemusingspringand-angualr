package com.jfsfeb.stockmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jfsfeb.stockmanagement.dto.Stock;

@Repository
public class StockDAOImpl implements StockDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addStock(Stock stock) {
		boolean isAdded = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(stock);
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

	@Override
	public boolean deleteStock(int stockId) {
		boolean isDeleted = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Stock stock = manager.find(Stock.class, stockId);
		if (stock != null) {
			try {
				transaction.begin();
				manager.remove(stock);
				transaction.commit();
				isDeleted = true;
			} catch (Exception e) {
				transaction.rollback();
			} finally {
				manager.close();
			}
		}
		return isDeleted;
	}

	@Override
	public boolean updateStock(int stockId, Stock stock) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			Stock bean = manager.find(Stock.class, stockId);
			if (bean != null) {
				transaction.begin();
				bean.setStockQuantity(stock.getStockQuantity());
				bean.setPrice(stock.getPrice());
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
	public List<Stock> getAllStocks() {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql = "from Stock";
			TypedQuery<Stock> query = manager.createQuery(jpql, Stock.class);
			return query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public Stock searchStock(int stockId) {
		EntityManager manager = factory.createEntityManager();
		try {
			Stock bean = manager.find(Stock.class, stockId);
			return bean;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

}