package it.polito.ai.lab2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

// Reads a JSON object or an array structure from an input source.
public class JsonFileReader {


	public static void read(){
		File jsonInputFile = new File("../linee.json");
		InputStream is;
		
		/*try {
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
			// read json array
			JsonArray arrObj = empObj.getJsonArray("direct_reports");
			System.out.println("\nDirect Reports:");
			for(JsonValue value : arrObj){
				System.out.println(value.toString());
			}*/
		
		try{
			is = new FileInputStream(jsonInputFile);
			// Create JsonReader from Json.
			JsonReader reader = Json.createReader(is);
			// Get the JsonObject structure from JsonReader.
			JsonObject jsonObj = reader.readObject();
			// read lines array
			JsonArray linesArr = jsonObj.getJsonArray("lines");
			System.out.println("Lines:");
			
			
			for(JsonValue value : linesArr){
				System.out.println(value.toString());
			}

			// read single line element from lines list
			for(int i = 0; i < linesArr.size(); i++){
				JsonObject elementObj = linesArr.getJsonObject(i);

				// read line data
				//JsonObject lineObj = elementObj.getJsonObject("line");
				System.out.println("\nLine: " + elementObj.getString("line"));

				// read desc data
				//JsonObject descObj = elementObj.getJsonObject("desc");
				System.out.println("Desc: " + elementObj.getString("desc"));

				// read stops array
				JsonArray stopsArr = elementObj.getJsonArray("stops");
				System.out.print("Stops:");

				// read stop data
				for(JsonValue value : stopsArr){
					System.out.print(value.toString());
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found error.\n");
			e.printStackTrace();
		}
	}
}
