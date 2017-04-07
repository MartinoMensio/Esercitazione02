package it.polito.ai.lab2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class DBToGeoJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DBToGeoJson() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}



}
