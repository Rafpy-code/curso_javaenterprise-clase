<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contador de sesion</title>
<style type="text/css">
div {
	width: 30%;
	margin: 50px auto;
	border: 1px solid crimson;
	box-shadow: 5px 5px 5px crimson;
	margin: 50px auto;
}
</style>
</head>
<body>

	<div>
		<div>
			<h2>Has entrado</h2>
			<h1><%=session.getAttribute("contador")%></h1>
			<h2>veces</h2>
		</div>
		<div>
			<h2>
				Número GLOBAL de visitas a esta página:
				<%=application.getAttribute("global")%></h2>
		</div>
	</div>
	<a href="index.html">VOLVER</a>
</body>
</html>