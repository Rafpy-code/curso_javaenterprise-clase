<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	<h1 style="color: red">
		El usuario "<%=request.getParameter("usuario")%>" no existe
	</h1>
	<a href="login.html">Volver</a>
</body>
</html>