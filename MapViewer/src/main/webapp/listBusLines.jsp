<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="org.hibernate.*, java.util.*, it.polito.ai.lab2.entities.*"%>
<%@ page import="java.net.*"%>
<!DOCTYPE html>
<html>
<head>
<base
	href="<%=new URL(request.getScheme(), request.getServerName(), request.getServerPort(),
					request.getContextPath())%>/">
<title>${title}</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="css/style.css"></link>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
</head>
<body>
	<div id="pageheader" class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<%@include file="components/navbar.jsp"%>
		</div>
	</div>
	<div class="container" style="padding-top: 100px; padding-left: 250px">
		<div id="body" class="row">
			<div style="padding-top: 50px;">
				<h1>List of Bus Lines</h1>


				<p>**********************************************</p>
				<p>**** here there will the list of the busLines</p>
				<ul class="map_redirections">
					<%
						Query query = ((Session) request.getAttribute("session")).createQuery("From BusLine l order by l.line");
						List<BusLine> busLineList = query.list();
						for (BusLine busLine : busLineList) {
					%>
					<li><a href="mapPage.jsp?line=<%=busLine.getLine()%>"><%=busLine.getLine() + " - " + busLine.getDescription()%></a></li>
					<%
						}
					%>
				</ul>
				<p>**********************************************</p>
				<p>**** selezionando una linea, bisogna essere reindirizzati
					alla pagina della mappa</p>
				<p>**** e creare la polilinea corrispondente alle fermate</p>
				<p>**** ad esempio, cliccando una linea -> redirezione a mapPage
					insieme a un parametro (numero linea)</p>

				<br> <br> <br> <br>

			</div>
		</div>
	</div>
</body>
>