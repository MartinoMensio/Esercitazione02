package it.polito.ai.lab2;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.*;
import org.json.JSONArray;
import org.json.JSONObject;

import it.polito.ai.lab2.entities.BusLine;
import it.polito.ai.lab2.entities.BusStop;

@WebServlet("/getBusStops")
public class DBToGeoJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Preleva i dati dal database e li traduce in un file .json seguendo il modello GeoJSON
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Salvataggio in una lista di BusLine e di BusStop dei dati presenti nel database
		request.getSession(); //TODO Sostituire?
		String line = request.getParameter("line");

		Query query = ((Session) request.getAttribute("session")).createQuery("From BusLine where BusLine.line=:line");
		query.setString("line", line);
		BusLine busLine = (BusLine) query.list().get(0);

		List<BusStop> busStopList = busLine.getStops();

		// Parsing degli stop
		JSONObject geoJSON = busStopsToGeoJson(busStopList);
		System.out.println(geoJSON.toString());
		
		response.getWriter().println("<h1>Ecco le fermate!!!</h1>");
		response.setContentType("text/html");
	}

	protected JSONObject busStopsToGeoJson(List<BusStop> busStopList) {
		JSONObject root = new JSONObject();
		root.put("type", "FeatureCollection");
		
		JSONArray features = new JSONArray();
		for (BusStop stop : busStopList) {
			// Create coordinate object and set latitude and longitude
			JSONArray coordinates = new JSONArray();
			coordinates.put(stop.getLongitude());
			coordinates.put(stop.getLatitude());
			
			// Create and fill up the geometry object with type and coordinates
			JSONObject geometry = new JSONObject();
			geometry.put("type", "Point");
			geometry.put("coordinates", coordinates);
			
			// Create and fill up the properties object
			JSONObject properties = new JSONObject();
			properties.put("popupContent", stop.getName());
			
			// Create and fill up the bus stop object with type, geometry, id and properties
			JSONObject feature = new JSONObject();
			feature.put("type", "Feature");
			feature.put("geometry", geometry);
			feature.put("id", stop.getId());
			feature.put("properties", properties);
			
			// Add the single feature to the feature collection
			features.put(feature);
		}
		
		return root;
	}
}
