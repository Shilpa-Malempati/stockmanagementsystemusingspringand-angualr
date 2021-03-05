package com.jfsfeb.stockmanagement.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsfeb.stockmanagement.dao.UserDAO;
import com.jfsfeb.stockmanagement.dto.User;
import com.jfsfeb.stockmanagement.exception.ValidationException;
import com.jfsfeb.stockmanagement.util.Validation;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO dao;

	@Override
	public boolean addUser(User user) {
		Validation v = new Validation();
		String email = user.getEmail();
		if(Validation.userEmailValidation(email)) {
			user.setEmail(email);
		}else{
			throw new ValidationException("Enter proper format for email such as 'Abc123@gmail.com'");
		}
//		String password = user.getPassword();
//		if(Validation.passwordValidation(password)) {
//			user.setPassword(password);
//		}else{
//			throw new ValidationException("Enter proper format for password such as 'Abc123@'");
//		}
		String name = user.getName();
		if(v.nameValidation(name)) {
			user.setName(name);
		}else{
			throw new ValidationException("Alphabets are only allowed...");
		}
//		String role = user.getRole();
//		if(v.roleValidation(role)) {
//			user.setRole(role);
//		}else{
//			throw new ValidationException("Role such as admin,manager and investor is only allowed");
//		}
		return dao.addUser(user);
	}

	@Override
	public boolean deleteUser(int userId) {
		return dao.deleteUser(userId);
	}

	@Override
	public boolean updatePassword(int userId, String password) {
		return dao.updatePassword(userId, password);
	}

	@Override
	public User loginUser(String email, String password) {
		return dao.loginUser(email, password);
	}

	@Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public User getUser(int userId) {
		return dao.getUser(userId);
	}
}