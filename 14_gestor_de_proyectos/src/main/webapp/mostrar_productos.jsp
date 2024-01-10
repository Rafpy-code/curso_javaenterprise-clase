<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, java.util.ArrayList, model.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de productos por categoría</title>
<style type="text/css">
body {
	color: purple;
}

h1 {
	text-align: center;
}

div {
	width: 40%;
	margin: 50px auto;
	padding: 15px;
	background-color: smocke;
	border: 1px solid purple;
}

table {
	border: 1px dashed purple;
	margin: 0 auto;
}

th, td {
	padding: 5px;
	border: 1px solid purple;
}
td{
text-align: right;
}
a {
	display: block;
	width:40%;
	border: 1px solid purple; 
	margin: 0 auto;
	margin-bottom : 20px;
	padding: 15px;
	margin-top: 20px;
	text-decoration: none;
	text-align: center;
}
a:hover {
	background: purple;
	color:white;
}
</style>
</head>
<body>
	<div>
		<h1>Lista de productos por categoría:</h1>
		<table>
			<tr>
				<th>PRODUCTO</th>
				<th>PRECIO</th>
			</tr>
			<tr>
				<%--Esto viene del request.setAttribute("encontrados", encontrados); --%>
				<%
				List<Producto> resultados = (List<Producto>)request.getAttribute("encontrados");
				for (Producto p : resultados) {
				%>
				<td><%=p.getNombre()%></td>
				<td><%=p.getPrecio()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<a href="index.html">Menú Principal</a>
	</div>
</body>
</html>