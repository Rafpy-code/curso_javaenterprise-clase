<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.Ficha"%><%--hacer el imoport de las clases a usar--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login correcto</title>
<style>
a {
	width:60px;
	margin-top: 20px;
	display: inline-block;
	text-decoration: none;
	text-align:center;
	color:green;
	border: 0.5px solid green;
	padding: 10px;
}
</style>
</head>
<body>
	<%--recuperamos la ficha y hacemos el casting (Ficha) --%>
	<%
	Ficha f = (Ficha) request.getAttribute("ficha");
	%>
	<h1 style="color: green">
		Bienvenido usuario
		<%=request.getParameter("usuario")%>
	</h1>
	<h2>
		Ficha de
		<%
	request.getParameter("usuario");
	%>
	</h2>
	<h3>
		Nombre
		<%
	f.getUsuario();
	%>
	</h3>
	<h3>
		Edad:
		<%=f.getEdad()%></h3>
	<h3>
		Email:
		<%=f.getEmail()%></h3>
	<a href="login.html">Salir</a>
</body>
</html>