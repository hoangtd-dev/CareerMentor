package com.example.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.example.DBConnectionManager;

public class UserDAO {
	public Optional<User> findByEmail(String email) throws SQLException {
		String sql = "SELECT id, name, email, password_hash FROM users WHERE email = ?";

		try (Connection conn = DBConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, email);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return Optional.of(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
							rs.getString("password_hash")));
				}
			}
		}

		return Optional.empty();
	}

	public boolean create(String name, String email, String passwordHash) throws SQLException {
		String sql = "INSERT INTO users (name, email, password_hash) VALUES (?, ?, ?)";

		try (Connection conn = DBConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, passwordHash);
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
