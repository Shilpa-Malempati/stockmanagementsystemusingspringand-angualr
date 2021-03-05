package com.capgemini.stockmanagement.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jfsfeb.stockmanagement.dao.UserDAO;
import com.jfsfeb.stockmanagement.dto.User;

@SpringBootTest
class UserDAOTest {

	@Autowired
	private UserDAO dao;
	private User user = new User();

	@Test
	void testAddUser() {
		try {
			User user = new User();
			user.setEmail("priya@gmail.com");
			user.setName("Priya");
			user.setPassword("Priya@123");
			user.setRole("ComapanyManager");
			boolean result = dao.addUser(user);
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				dao.addUser(user);
			});
		}
	}

	@Test
	void testDeleteUser() {
		try {
			User user = new User();
			user.setUserId(1002);
			boolean result = dao.deleteUser(user.getUserId());
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				dao.addUser(user);
			});
		}
	}

	@Test
	void testUpdatePassword() {
		try {
			User user = new User();
			user.setUserId(1003);
			user.setPassword("Manager@123");
			boolean result = dao.updatePassword(user.getUserId(), user.getPassword());
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				dao.addUser(user);
			});
		}
	}

	@Test
	void testLoginUser() {
		try {
			User user = new User();
			user.setEmail("manager1@gmail.com");
			user.setPassword("Manager1@123");
			User result = dao.loginUser(user.getEmail(), user.getPassword());
			assertNotNull(result);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				dao.addUser(user);
			});
		}
	}

	@Test
	void testGetAllUsers() {
		List<User> user = dao.getAllUsers();
		assertNotNull(user);
	}

}
