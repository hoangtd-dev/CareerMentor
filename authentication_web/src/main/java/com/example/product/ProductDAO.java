package com.example.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.DBConnectionManager;

public class ProductDAO {
	public List<Product> findAll() throws SQLException {
		List<Product> products = new ArrayList<>();
		String sql = "SELECT id, name, price FROM products";

		try (Connection conn = DBConnectionManager.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
			}
		}

		return products;
	}
}
