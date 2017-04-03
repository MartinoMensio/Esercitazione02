<%@ tag language="java" pageEncoding="UTF-8"%> 
<%@ tag import="java.net.*"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@attribute name="sidenav" fragment="true"%>
<%@attribute name="title"%>
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
<body>
	<div id="pageheader" class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<jsp:invoke fragment="header" />
		</div>
	</div>
	<div id="sidenav" class="navbar-fixed-top vertical-center"
		style="width: 250px; margin-top:50px;">
		<jsp:invoke fragment="sidenav" />
	</div>
	<div class="container" style="padding-top: 50px; padding-left: 250px">
		<div id="body" class="row">
			<jsp:doBody />
		</div>
		<div id="pagefooter" class="row">
			<jsp:invoke fragment="footer" />
		</div>

	</div>
</body>
</html>