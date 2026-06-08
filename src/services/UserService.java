package services;

import java.util.ArrayList;

import interfaces.IRepository;
import models.User;

public class UserService {
	private final IRepository<User> repository;

	public UserService(IRepository<User> repository) {
		this.repository = repository;
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
}
