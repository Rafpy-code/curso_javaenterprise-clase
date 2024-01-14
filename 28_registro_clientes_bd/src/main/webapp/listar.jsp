<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" import="model.Cliente, java.util.List"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
<title>Lista de Clientes</title>
<link rel="stylesheet" href="estilos.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<h1 class="display-1">Lista de Clientes</h1>
		<br>
		<c:if test="${!empty requestScope.clientes}">
			<table class="table table-success table-striped">
				<thead>
					<tr class="table-primary">
						<th>ID</th>
						<th>NOMBRE</th>
						<th>APELLIDO</th>
						<th>FORMA DE PAGO</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cliente" items="${requestScope.clientes}">

						<tr>
							<th scope="row">${cliente.idCliente}</th>
							<td>${cliente.nombre}</td>
							<td>${cliente.apellido}</td>
							<td>${cliente.formaPago}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty requestScope.clientes}">
			<h1>No hay clientes registrados</h1>
		</c:if>
		<a class="icon-link" href="FrontController?operation=toMenu"> 
				<img class="bi-lg" aria-hidden="true" src="images/f48.png">
		</a> 
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
</body>
</html>