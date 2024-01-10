<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Contador de sesion</title>
<style type="text/css">
div {
	width: 65%;
	margin: 50px auto;
	border: 1px solid gray;
	box-shadow: 5px 5px 5px gray;
	margin: 50px auto;
}
a{
text-decoration: none;
}
</style>
</head>
<body>

	<div>
		<div>
			<%
			String fecha="Primera visita";
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("fecha")) {
						fecha = cookie.getValue();
					}
				}
			}
			%>
			<h3>
				Fecha de tu ultima visita:
				<%=fecha%></h3>
		</div>
		<div>
			<h2>Has entrado</h2>
			<h1><%=session.getAttribute("contador")%></h1>
			<h2>veces</h2>
		</div>
		<div>
			<h2>
				GLOBAL de visitas a este sitio:
				<%=application.getAttribute("global")%></h2>
		</div>
		<div>
		<a href="index.html">VOLVER</a>
		</div>
	</div>
	
</body>
</html>