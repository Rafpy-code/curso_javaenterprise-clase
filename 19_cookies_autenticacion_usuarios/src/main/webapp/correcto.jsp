<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="jakarta.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido</title>
</head>
<body>
	<h1 style="color: green">
		Bienvenido usuario:
		<%=request.getParameter("usuario")%>
	</h1>
	<a href="login.html">Salir</a>
</body>
</html>