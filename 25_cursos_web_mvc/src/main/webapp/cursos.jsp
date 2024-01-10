<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.Curso,java.util.ArrayList"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- los siguiente metas son para no- cache -->
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
<link rel="stylesheet" href="estilos.css">
<title>Lista</title>
</head>
<body>
	<center>
		<h1>
			Cursos cuyo precio máximo es ${param.precio }</h1>
		<br>
		<c:if test="${!empty requestScope.cursos}">
		<table border="1">
			<tr>
				<th>Nombre</th>
				<th>Duración</th>
				<th>Precio</th>
			</tr>

			<c:forEach var="curso" items="${requestScope.cursos}" varStatus="indice" >
			
			<tr>
				<td>${curso.nombre}</td>
				<td>${curso.duracion}</td>
				<td>${curso.precio}</td>
			</tr>
			</c:forEach>			
		</table>
		</c:if>
		<c:if test="${empty requestScope.cursos}">
			<h1>No hay cursos con ese criterio</h1>
		</c:if>
		<div>
			<br><a href="FrontController?operation=toMenu">MENU</a>
		</div>
	</center>
</body>
</html>