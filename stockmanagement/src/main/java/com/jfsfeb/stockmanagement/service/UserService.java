package com.jfsfeb.stockmanagement.service;
import java.util.List;

import com.jfsfeb.stockmanagement.dto.User;

public interface UserService {

	boolean addUser(User user);

	boolean deleteUser(int userId);

	boolean updatePassword(int userId, String password);

	User loginUser(String email, String password);

	List<User> getAllUsers();
	
	User getUser(int userId);
}
