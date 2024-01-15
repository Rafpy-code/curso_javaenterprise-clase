<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.Curso,java.util.ArrayList"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<title>Lista de todos los cursos disponibles</title>
</head>
<body>
	<div class="container">
		<h1 class="display-3 text-center">Cursos disponibles</h1>

		<c:if test="${!empty requestScope.cursos}">
			<table border="1" class="table table-striped">
				<thead>
					<tr class="table-dark">
						<th>Id</th>
						<th>Nombre</th>
						<th>Duración</th>
						<th>Precio</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="curso" items="${requestScope.cursos}">
						<tr>
							<td scope="row">${curso.idCurso}</td>
							<td>${curso.nombre}</td>
							<td>${curso.duracion}</td>
							<td>${curso.precio}</td>
							<td><a href="FrontController?operation=toModificarDuracion" type="submit" class="btn btn-warning">Editar</a></td>
							<td><a href="FrontController?operation=toEliminar" type="submit" class="btn btn-danger">
								Eliminar
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty requestScope.cursos}">
			<div class="container">
			<h1  class="display-4 alert alert-danger text-center  mt-5" role="info">No hay cursos registrados</h1>
			</div>
		</c:if>
		<a class="icon-link icon-link-hover"
			href="FrontController?operation=toMenu"><img height="50px" width="50px" src="images/right-arrow-svgrepo-com.svg">
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