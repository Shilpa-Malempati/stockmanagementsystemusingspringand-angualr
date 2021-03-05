package com.jfsfeb.stockmanagement.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.jfsfeb.stockmanagement.dto.User;
import com.jfsfeb.stockmanagement.exception.ValidationException;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addUser(User user) {
		boolean isAdded = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public boolean deleteUser(int userId) {
		boolean isDeleted = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		User user = manager.find(User.class, userId);
		if (user != null) {
			try {
				transaction.begin();
				manager.remove(user);
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
	public boolean updatePassword(int userId, String password) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			User bean = manager.find(User.class, userId);
			if (bean != null) {
				transaction.begin();
				bean.setPassword(password);
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
	public User loginUser(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql = "from User where email=:email and password=:password";
			TypedQuery<User> query = manager.createQuery(jpql, User.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			User record = query.getSingleResult();
			return record;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql = "from User";
			TypedQuery<User> query = manager.createQuery(jpql, User.class);
			return query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public User getUser(int userId) {
		String jpql = "from User where userId=:userId";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<User> query = manager.createQuery(jpql, User.class);
		query.setParameter("userId", userId);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
				throw new ValidationException("user not found");
			}
	}
	}

 