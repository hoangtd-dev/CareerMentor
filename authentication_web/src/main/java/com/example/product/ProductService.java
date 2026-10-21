package com.example.product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
	private final ProductDAO productDAO;

	public ProductService() {
		this(new ProductDAO());
	}

	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public List<Product> getAllProducts() throws SQLException {
		return productDAO.findAll();
	}
}
