package com.example.user;

import java.io.Serializable;

public class User implements Serializable {
	private int id;
	private String name;
	private String email;
	private String passwordHash;

	public User(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public User(int id, String name, String email, String passwordHash) {
		this(id, name, email);
		this.passwordHash = passwordHash;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}
}
