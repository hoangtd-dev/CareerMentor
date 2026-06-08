package handlers;

import java.time.LocalDate;
import java.util.ArrayList;

import interfaces.IRepository;
import models.User;

public class UserHandler {
	private final IRepository<User> repository;

	public UserHandler(IRepository<User> repository) {
		this.repository = repository;
	}

	public void register(String firstname, String lastname, LocalDate dob, String username, String password) {
		ArrayList<User> users = repository.load();

		users.add(new User(firstname, lastname, dob, username, password));

		repository.save(users);
	}

	public ArrayList<User> getAllUsers() {
		return repository.load();
	}

	public ArrayList<User> getByName(String searchText) {
		ArrayList<User> users = repository.load();
		ArrayList<User> result = new ArrayList<User>();

		for (User user : users) {
			if (user.hasName(searchText)) {
				result.add(user);
			}
		}

		return result;
	}

	public int login(String username, String password) {
		ArrayList<User> users = repository.load();

		for (User user : users) {
			boolean found = user.checkCredential(username, password);
			repository.save(users);

			if (user.isLooked()) {
				return -1;
			}

			if (found) {
				return 1;
			}
		}

		return 0;
	}
}
