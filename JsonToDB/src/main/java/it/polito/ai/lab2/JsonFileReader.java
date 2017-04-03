package it.polito.ai.lab2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

// Reads a JSON object or an array structure from an input source.
public class JsonFileReader {
	//JsonReaderFactory factory = Json.createReaderFactory(config);
	//JsonReader jsonReader = Json.createReader(new StringReader("[]"));
	//jsonReader.close();
	public static void read(){
		File jsonInputFile = new File("../linee.json");
		InputStream is;
		try {
			is = new FileInputStream(jsonInputFile);
			// Create JsonReader from Json.
			JsonReader reader = Json.createReader(is);
			// Get the JsonObject structure from JsonReader.
			JsonObject empObj = reader.readObject();
			reader.close();
			// read string data
			System.out.println("Emp Name: " + empObj.getString("emp_name"));
			// read integer data
			System.out.println("Emp Id: " + empObj.getInt("emp_id"));
			// read inner json element
			JsonObject addrObj = empObj.getJsonObject("address");
			System.out.println("City: " + addrObj.getString("city"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
