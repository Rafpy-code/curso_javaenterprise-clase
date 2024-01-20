<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Last-Modified" content="0" />
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<title>Selector de temas</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script defer type="text/javascript" src="buscador.js"></script>
</head>
<body>
	<div class="container">
	<h1 class="">Seleccione un tema</h1>
		<%-- <c:if test="${!empty requestScope.temas}"> --%>
		<select #isbn>
		<option value="0">Todos los temas</option>
				<c:forEach var="tema" items="${requestScope.temas}">	
					<option value="${tema.idTema}">${tema.tema}</option>		
			</c:forEach>
			</select>
		<%-- </c:if> --%>
	</div>
	<div #listaLibros></div>
</body>
</html>