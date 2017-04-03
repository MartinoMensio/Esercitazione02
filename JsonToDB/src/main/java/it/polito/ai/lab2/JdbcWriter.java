package it.polito.ai.lab2;

import java.sql.*;

public class JdbcWriter {
	
	private Connection connection;

	public JdbcWriter() {
		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/trasporti", "postgres",
					"ai-user-password");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public boolean insertBusLine(Object busline) {
		// TODO
		return false;
	}
	
	public boolean insertBusStop(Object busstop) {
		// TODO
		return false;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
