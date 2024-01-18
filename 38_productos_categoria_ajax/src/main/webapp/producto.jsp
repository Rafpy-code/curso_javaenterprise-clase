<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
<title>Gestor de Productos</title>
<link rel="stylesheet" href="estilos.css" />
</head>
<body>
	<div>
		<h3>Id: ${requestScope.producto.idProducto}</h3>
		<h3>Nombre: ${requestScope.producto.nombre}</h3>
		<h3>Categoría: ${requestScope.producto.categoria}</h3>
		<h3>Precio: ${requestScope.producto.precio}</h3>
		<br> <a href="FrontController?operation=toInicio">VOLVER</a>
	</div>
</body>
</html>