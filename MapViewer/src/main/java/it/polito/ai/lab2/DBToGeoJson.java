package it.polito.ai.lab2;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.*;
import org.json.JSONArray;
import org.json.JSONObject;

import it.polito.ai.lab2.entities.BusLine;
import it.polito.ai.lab2.entities.BusStop;

public class DBToGeoJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DBToGeoJson() {
		super();
		// TODO Auto-generated constructor stub
	}


	// Preleva i dati dal database e li traduce in un file .json seguendo il modello GeoJSON
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Salvataggio in una lista di BusLine e di BusStop dei dati presenti nel database
		request.getSession(); //TODO Sostituire?
		String line = request.getParameter("line");

		Query query = ((Session) request.getAttribute("session")).createQuery("from busline where busline.line=:line");
		query.setString("line", line);
		BusLine busLine = (BusLine) query.list().get(0);

		List<BusStop> busStopList = busLine.getStops();

		// Parsing degli stop
		for(BusStop stop : busStopList){
			busStopToGeoJson(stop);
		}


		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected JSONObject busStopToGeoJson(BusStop busStop){
		// Traduzione in Json
		JSONObject featureCollection = new JSONObject();
		featureCollection.put("type", "FeatureCollection");
		JSONObject properties = new JSONObject();
		properties.put("name", "ESPG:4326");
		JSONObject crs = new JSONObject();
		crs.put("type", "name");
		crs.put("properties", properties);
		featureCollection.put("crs", crs);

		JSONArray features = new JSONArray();
		JSONObject feature = new JSONObject();
		feature.put("type", "Feature");
		JSONObject geometry = new JSONObject();

		return null;

	}



}
