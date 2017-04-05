<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
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
		<h1>List of Bus Lines</h1>
		

<p> **********************************************  </p>
<p> **** here there will the list of the busLines  </p>
	<ul class="map_redirections">
	<li><a href="mapPage.jsp">LineaEsempio1</a></li>
	<li><a href="mapPage.jsp">LineaEsempio2</a></li>
	</ul>
<p> **********************************************  </p>
<p> **** selezionando una linea, bisogna essere reindirizzati alla pagina della mappa </p>
<p> **** e creare la polilinea corrispondente alle fermate </p>
<p> **** ad esempio, cliccando una linea -> redirezione a mapPage insieme a un parametro (numero linea) </p>
	
<br> <br> <br> <br> 

    </div>    
    </jsp:body>
</t:template>