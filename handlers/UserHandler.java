package handlers;

import java.time.LocalDate;
import java.util.ArrayList;

import interfaces.IRepository;
import models.User;

public class UserHandler {
	private final IRepository<User> _repository;

	public UserHandler(IRepository<User> repository) {
		_repository = repository;
	}

	public void register(String firstname, String lastname, LocalDate dob, String username, String password) {
		ArrayList<User> users = _repository.load();

		users.add(new User(firstname, lastname, dob, username, password));

		_repository.save(users);
	}

	public ArrayList<User> getAllUsers() {
		return _repository.load();
	}

	public ArrayList<User> getByName(String searchText) {
		ArrayList<User> users = _repository.load();
		ArrayList<User> result = new ArrayList<User>();

		for (User user : users) {
			if (user.hasName(searchText)) {
				result.add(user);
			}
		}

		return result;
	}

	public int login(String username, String password) {
		ArrayList<User> users = _repository.load();

		for (User user : users) {
			boolean found = user.checkCredential(username, password);
			_repository.save(users);

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
