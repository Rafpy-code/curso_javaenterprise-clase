<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Tema"%>
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
<link rel="stylesheet" href="./css/estilos.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script defer type="text/javascript" src="lanzador.js"></script>
</head>
<body bg-slate-200>
	<c:if test="${!empty requestScope.temas}">
		<div class="text-center w-64 mt-2 p-5">
			<select name="seleccion" id="idTema" title="Elegir libros"
				class="text-center mx-auto text-2xl font-bold text-white block w-full px-4 py-4 border rounded-md bg-amber-400 focus:outline-none focus:border-amber-400">
				<option>ELIGE UNA OPCIÓN</option>
				<option value="0">Todos los temas</option>
				<c:forEach var="t" items="${requestScope.temas}">
					<option value="${t.idTema}">${t.tema}</option>
				</c:forEach>
			</select>
		</div>
	</c:if>
	<div class="container rounded-md mx-auto p-5">
		<img id="spinner" src="assets/bouncing-squares.svg"
			style="display: none">
		<table id="listaLibros"
			class="table-fixed w-full rounded-md bg-amber-400 mx-auto"></table>
	</div>

	<div id="carritoVista" class="container rounded-md mx-auto p-5">
		<h2 class="text-center text-2xl">Carrito</h2>
		<table id="listaLibrosComprados"
			class="table-fixed w-full rounded-md bg-amber-400 mx-auto">
	
		</table>
	</div>
</body>
</html>
