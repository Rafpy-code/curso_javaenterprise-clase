<%@page import="model.Producto, java.util.List, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrito</title>
<style type="text/css">
body {
	color: crimson;
}

h1 {
	text-align: center;
}

div {
	width: 60%;
	margin: 50px auto;
	padding: 15px;
	background-color: smocke;
	border: 1px solid purple;
}

table {
	border: 1px dashed crimson;
	margin: 0 auto;
}

th, td {
	padding: 5px;
	border: 1px solid crimson;
}

td {
color: darkblue;
	text-align: right;
}

a {
	color: crimson;
	display: block;
	width: 90%;
	border: 1px solid crimson;
	margin: 0 auto;
	margin-bottom: 20px;
	padding: 5px;
	margin-top: 20px;
	text-decoration: none;
	text-align: center;
}

a:hover {
	color: crimson;
	color: white;
}

img{
width: 20px;
height: 20px;
}
</style>
</head>
<body>
	<%
	request.getSession();
	%>
	<div>
		<h1>Carrito</h1>
		<a href="CerrarSesionServlet">CERRAR SESION</a>
		<table>
			<tr>
				<th>PRODUCTO</th>
				<th>PRECIO</th>
				<th>CATEGORIA</th>
				<th>ELIMINAR</th>
			</tr>
			<tr>
				<%
				List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");
				
				if(carrito != null){
				for (Producto p : carrito) {
				%>
				<td><%=p.getNombre()%></td>
				<td><%=p.getPrecio()%></td>
				<td><%=p.getCategoria()%></td>
				<td><a href="EliminarProductoServlet?nombre=<%=p.getNombre()%>"><img src="images/trash-can.png" /></a></td>
			</tr>
			<%
			}}
			%>

		</table>
		<a href="index.html">INICIO</a>
	</div>
</body>
</html>