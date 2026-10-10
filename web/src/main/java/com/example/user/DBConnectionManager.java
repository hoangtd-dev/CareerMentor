package com.example.user;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DBConnectionManager {
	private static final MysqlDataSource dataSource = buildDataSource();

	private static MysqlDataSource buildDataSource() {
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName(System.getenv("DB_HOST"));
		ds.setPort(Integer.parseInt(System.getenv("DB_PORT")));
		ds.setDatabaseName(System.getenv("DB_NAME"));
		ds.setUser(System.getenv("DB_USER"));
		ds.setPassword(System.getenv("DB_PASSWORD"));
		return ds;
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
