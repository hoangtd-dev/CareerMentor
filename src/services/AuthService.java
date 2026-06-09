package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import enums.LoginStatusEnum;
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

	public User getUser() {
		return authUser;
	}

	public boolean register(String firstname, String lastname, LocalDate dob, String username, String password) {
		ArrayList<User> users = repository.load();

		boolean isExisted = isUsernameExisted(users, username);

		if (isExisted)
			return false;

		users.add(new User(firstname, lastname, dob, username, password));

		repository.save(users);
		return true;
	}

	public LoginStatusEnum login(String username, String password) {
		ArrayList<User> users = repository.load();

		try {
			User matchedUser = users.stream()
					.filter(user -> user.getUsername().equals(username))
					.toList()
					.getFirst();

			if (matchedUser.isLooked()) {
				return LoginStatusEnum.Locked;
			}

			boolean result = matchedUser.checkCredential(username, password);
			repository.save(users);

			if (!result) {
				return LoginStatusEnum.Fail;
			}

			authUser = matchedUser;
			return LoginStatusEnum.Success;
		} catch (NoSuchElementException e) {
			return LoginStatusEnum.Fail;
		}
	}

	private boolean isUsernameExisted(List<User> users, String username) {
		return users.stream().anyMatch(user -> user.getUsername().equals(username));
	}
}
