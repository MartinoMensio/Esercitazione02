package it.polito.ai.lab2;

public class Main {

	public static void main(String[] args) {
		
		JdbcWriter jdbcWriter = new JdbcWriter();
		System.out.println("Connected to db");
		
		// TODO ask to JsonFileReader all the data
		
		// TODO put all the data in DB calling JdbcWriter
		
		jdbcWriter.close();
		System.out.println("done");
	}

}
