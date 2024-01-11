<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.Producto, java.util.List"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
<title>Productos por Categoría</title>
<link rel="stylesheet" href="estilos.css" />
</head>
<body>
	<div>
		<h1>Produtos por categoría: ${param.categoria}</h1>
		<table>
			<tr>
				<th>ID</th>
				<th>NOMBRE</th>
				<th>CATEGORÍA</th>
				<th>PRECIO</th>
			</tr>
			<c:forEach var="producto" items="${requestScope.productos}">
				<tr>
					<td>${producto.idProducto }</td>
					<td>${producto.nombre}</td>
					<td>${producto.categoria}</td>
					<td>${producto.precio}</td>
				</tr>
			</c:forEach>
		</table>

		<br> <a href="FrontController?operation=toInicio">VOLVER</a>
	</div>
</body>
</html>
