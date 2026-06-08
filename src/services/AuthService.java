package services;

import java.time.LocalDate;
import java.util.ArrayList;

import enums.LoginStatus;
import interfaces.IRepository;
import models.User;

public class AuthService {
	private final IRepository<User> repository;
	private User authUser = null;

	public AuthService(IRepository<User> repository) {
		this.repository = repository;
	}

	public boolean isAuth() {
		return authUser != null;
	}

	public void logout() {
		authUser = null;
	}

	public void register(String firstname, String lastname, LocalDate dob, String username, String password) {
		ArrayList<User> users = repository.load();

		users.add(new User(firstname, lastname, dob, username, password));

		repository.save(users);
	}

	public LoginStatus login(String username, String password) {
		ArrayList<User> users = repository.load();

		for (User user : users) {
			boolean found = user.checkCredential(username, password);
			repository.save(users);

			if (user.isLooked()) {
				return LoginStatus.Locked;
			}

			if (found) {
				authUser = user;
				return LoginStatus.Success;
			}
		}

		return LoginStatus.Fail;
	}
}
