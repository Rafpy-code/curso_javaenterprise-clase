<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.Resultado,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>13_buscador_atributos_peticion</title>
<style>
@charset "UTF-8";

@import
	url('https://fonts.googleapis.com/css2?family=Homenaje&family=Lobster&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

:root {
	--background: linear-gradient(to right top, #153b734f, #00bf737c, #a6eb1270);
	--url-img: url(./img/zhangzui-Pf23Y30hD68-unsplash.jpg);
	--bradius: border-radius: 3px;
}

body {
	width: 100%;
	height: 100vh;
	font-family: 'Lobster', 'Homenaje', sans-serif;
	letter-spacing: 1.5px;
	background-image: var(--background), var(--url-img);
	background-position: center;
	background-size: cover;
}
</style>
</head>
<body>
	<%
	List<Resultado> resultados = (List<Resultado>) request.getAttribute("paginas");
	for (Resultado r : resultados) {
	%>
	<h2>
		<a href="<%=r.getUrl()%>"><%=r.getUrl()%></a>
	</h2>
	<h3><%=r.getTematica()%></h3>
	<h4><%=r.getDescripcion()%></h4>
	<hr>
	<%
	}
	%>
	<br>
	<a href="buscador.html">Volver</a>
</body>
</html>