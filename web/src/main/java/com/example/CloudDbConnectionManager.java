package com.example;

import java.sql.Connection;
import java.sql.SQLException;

import org.postgresql.ds.PGSimpleDataSource;

public class CloudDbConnectionManager {
	private static final PGSimpleDataSource dataSource = buildDataSource();

	private static PGSimpleDataSource buildDataSource() {
		PGSimpleDataSource ds = new PGSimpleDataSource();

		ds.setServerNames(new String[] { System.getenv("POSTGRESQL_SERVERNAME") });
		ds.setPortNumbers(new int[] { Integer.parseInt(System.getenv("POSTGRESQL_PORT")) });
		ds.setDatabaseName(System.getenv("POSTGRESQL_NAME"));
		ds.setUser(System.getenv("POSTGRESQL_USER"));
		ds.setPassword(System.getenv("POSTGRESQL_PASSWORD"));
		ds.setSslMode("require");
		return ds;
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
