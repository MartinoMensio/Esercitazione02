package it.polito.ai.lab2;

import java.sql.*;

import it.polito.ai.lab2.objects.*;

public class JdbcWriter {

	private Connection connection;
	private String insertBusLineStr = "INSERT INTO BusLine(line, description) values (?, ?)";
	private String insertBusStopStr = "INSERT INTO BusStop(id, name, lat, long) values (?, ?, ?, ?)";
	private String insertBusLineStopStr = "INSERT INTO BusLineStop(stopId, lineId, sequenceNumber) values (?, ?, ?)";

	private PreparedStatement busLineInsertStmt;
	private PreparedStatement busStopInsertStmt;
	private PreparedStatement busLineStopInsertStmt;

	public JdbcWriter() {
		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/trasporti", "postgres",
					"ai-user-password");
			connection.setAutoCommit(false);
			busLineInsertStmt = connection.prepareStatement(insertBusLineStr);
			busStopInsertStmt = connection.prepareStatement(insertBusStopStr);
			busLineStopInsertStmt = connection.prepareStatement(insertBusLineStopStr);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Always insert all the stops before adding the bus lines, because of
	 * foreign keys
	 * 
	 * @param busLine
	 * @return
	 */
	public boolean insertBusLine(BusLine busLine) {
		busLineInsertStmt.setString(1, busLine.getLine());
		busLineInsertStmt.setInt(2, busLine.getDescription());
		int result = busLineInsertStmt.executeUpdate();
		return result == 1;
	}

	boolean insertBusLineStop(BusLine busLine) {
		int seqNumber = 0;
		int inserted;
		for (String stopId : busLine.getStops()) {
			busLineStopInsertStmt.setString(1, stopId);
			busLineStopInsertStmt.setString(2, busLine.getLine());
			busLineStopInsertStmt.setInt(3, seqNumber);
			inserted += busLineStopInsertStmt.executeUpdate();
			seqNumber++;
		}
		return inserted == busLine.getStops().size();
	}

	public boolean insertBusStop(BusStop busStop) {
		busStopInsertStmt.setString(1, busStop.getId());
		busStopInsertStmt.setString(2, busStop.getName());
		busStopInsertStmt.setDouble(3, busStop.getLat());
		busStopInsertStmt.setDouble(4, busStop.getLng());
		int result = busStopInsertStmt.executeUpdate();
		return result == 1;
	}

	/**
	 * to save after some calls to the insert functions
	 */
	public void save() {
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			close();
		}
	}

	/**
	 * to close the connection to the db
	 */
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
