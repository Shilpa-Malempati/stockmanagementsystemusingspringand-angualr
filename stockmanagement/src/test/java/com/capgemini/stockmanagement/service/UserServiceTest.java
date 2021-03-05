package com.capgemini.stockmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jfsfeb.stockmanagement.dto.User;
import com.jfsfeb.stockmanagement.service.UserService;

@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService service;
	private User user = new User();

	@Test
	void testAddUser() {
		try {
			User user = new User();
			user.setEmail("priya@gmail.com");
			user.setName("Priya");
			user.setPassword("Priya@123");
			user.setRole("Admin");
			boolean result = service.addUser(user);
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				service.addUser(user);
			});
		}
	}

	@Test
	void testDeleteUser() {
		try {
			User user = new User();
			user.setUserId(1002);
			boolean result = service.deleteUser(user.getUserId());
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				service.addUser(user);
			});
		}
	}

	@Test
	void testUpdatePassword() {
		try {
			User user = new User();
			user.setUserId(1003);
			user.setPassword("Mana@123");
			boolean result = service.updatePassword(user.getUserId(), user.getPassword());
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				service.addUser(user);
			});
		}
	}

	@Test
	void testLoginUser() {
		try {
			User user = new User();
			user.setEmail("manager1@gmail.com");
			user.setPassword("Manager1@123");
			User result = service.loginUser(user.getEmail(), user.getPassword());
			assertNotNull(result);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				service.addUser(user);
			});
		}
	}

	@Test
	void testGetAllUsers() {
		List<User> user = service.getAllUsers();
		assertNotNull(user);
	}

}
