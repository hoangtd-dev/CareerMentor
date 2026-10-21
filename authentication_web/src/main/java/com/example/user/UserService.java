package com.example.user;

import java.sql.SQLException;
import java.util.Optional;

import com.example.PasswordUtil;

public class UserService {
	private final UserDAO userDAO;

	public UserService() {
		this(new UserDAO());
	}

	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public Optional<User> login(String email, String password) throws SQLException {
		return userDAO.findByEmail(email).filter(user -> PasswordUtil.verify(password, user.getPasswordHash()));
	}

	public boolean register(String name, String email, String password) throws SQLException {
		return userDAO.create(name, email, PasswordUtil.hash(password));
	}
}
