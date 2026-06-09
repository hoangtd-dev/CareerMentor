package services;

import java.util.ArrayList;
import java.util.List;

import interfaces.IRepository;
import models.User;
import repositories.UserRepository;

public class UserService {
	private final IRepository<User> repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public ArrayList<User> getAllUsers() {
		return repository.load();
	}

	public List<User> getByName(String searchText) {
		ArrayList<User> users = repository.load();

		return users.stream().filter(user -> user.hasName(searchText)).toList();
	}
}
