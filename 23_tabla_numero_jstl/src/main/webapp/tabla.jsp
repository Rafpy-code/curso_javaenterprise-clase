<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabla de multiplicar</title>
<style type="text/css">
h1 {
	text-align: center;
	color: purple;
}

table {
	margin: 50px auto;
	border: 1px solid blue;
}
</style>
</head>
<body>
	<h1>Tabla del ${param.numero}</h1>
	<table>
		<c:forEach var="i" begin="1" end="10" step="1">
		<tr>
			<td>${i} * ${param.numero}</td>
			<td> = ${i*param.numero}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>