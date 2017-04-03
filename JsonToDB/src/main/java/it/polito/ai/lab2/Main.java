package it.polito.ai.lab2;

import java.util.List;

import it.polito.ai.lab2.objects.*;

public class Main {

	public static void main(String[] args) {
		
		JdbcWriter jdbcWriter = new JdbcWriter();
		System.out.println("Connected to db");
		
		// TODO ask to JsonFileReader all the data
		List<BusLine> busLines = null;
		List<BusStop> busStops = null;
		
		// put all the data in DB calling JdbcWriter
		for (BusStop busStop : busStops) {
			jdbcWriter.insertBusStop(busStop);
		}
		
		for (BusLine busLine : busLines) {
			jdbcWriter.insertBusLine(busLine);
		}
		
		jdbcWriter.close();
		System.out.println("done");
	}

}
