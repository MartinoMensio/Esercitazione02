<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.0.3/dist/leaflet.css" />
<script src="https://unpkg.com/leaflet@1.0.3/dist/leaflet.js"></script>
<link rel="stylesheet" href="leaflet-routing-machine-3.2.5/dist/leaflet-routing-machine.css" />
<script src="leaflet-routing-machine-3.2.5/dist/leaflet-routing-machine.js"></script>


  

<t:template>
	<jsp:attribute name="header">
      <%@include file="components/navbar.jsp"%>
    </jsp:attribute>
	<jsp:attribute name="footer">
      <div id="pagefooter" class="row">
			<%@include file="components/footer.jsp"%>
		</div>
    </jsp:attribute>
	<jsp:body>
	<div style="padding-top: 50px;">
		<h1>Map of Turin</h1>
		
<div id="mapid" style="width: 600px; height: 400px;"></div>

<script src="busStops.jsp" type="text/javascript"></script>

<script>

	var mymap = L.map('mapid').setView([45.064, 7.681], 13);

	//var mymap = L.map('mapid');
	L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
		maxZoom: 18, id: 'mapbox.streets'
	}).addTo(mymap);
	
	L.geoJSON(busStops).addTo(mymap);
	
	/*L.Routing.control({
		  waypoints: [
		    L.latLng(45.0415, 7.67959),
		    L.latLng(45.06098, 7.68101)
		  ],
	routeWhileDragging: true
		}).addTo(mymap);*/
	/*
	L.marker([45.06, 7.68]).addTo(mymap)
		.bindPopup("<b>Welcome!</b><br />Turin city map").openPopup();
	*/
	// you should receive a parameter with the number of busLine, then create the polyline
	// here you can add a polyline, insert a vector of LatLng
	// var polyline = L.polyline(latlngs, {color: 'red'}).addTo(mymap);
	// you can take a look to geoJSON here:    http://leafletjs.com/examples/geojson/
	/*var examplePolyline = L.polyline([[45.064, 7.681],[45.067, 7.678],[45.069, 7.675]], {color: 'red'}).addTo(mymap); // example of polyline
	mymap.fitBounds(examplePolyline.getBounds());  // it is used to zoom in/out and see the whole polyline on the map
	
	
	var popup = L.popup();

	function onMapClick(e) {
		popup
			.setLatLng(e.latlng)
			.setContent("You clicked the map at " + e.latlng.toString())
			.openOn(mymap);
	}

	mymap.on('click', onMapClick);
	*/
	
	// example of popup for busLines passing from a certain busStop
	/* var popup = L.popup();

	function onMapClick(e) {
		
		var numBusStop = "XX"; // you need to identify the busStop which have been clicked
		var linesOfBusStop = "YYY, YYX, YXZ"; // you need to identify the busLines of the busStop
		
		popup
			.setLatLng(e.latlng)
			.setContent("The lines passing to bus stop n."+ numBusStop +"\n["+e.latlng.toString()+"] are:\n" + linesOfBusStop)
			.openOn(mymap);
	}

	mymap.on('click', onMapClick); */
	
	
</script>

<br> <br> <br> <br> 

    </div>    
    </jsp:body>
</t:template>
