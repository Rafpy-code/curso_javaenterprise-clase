<%@page import="java.util.Comparator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.*, java.util.List, java.util.Comparator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lista de cursos por precio</title>
<link rel="stylesheet" href="menu_gestor_cursos.css" />
</head>
<body>
	<article>
		<h1>Lista de cursos por precio máximo</h1>
		<table border="1px">
			<tr>
				<th>CURSO</th>
				<th>DURACIÓN</th>
				<th>PRECIO</th>
			</tr>
			<tr>
				<%
				List<Curso> cursosEncontrados = (List)request.getSession().getAttribute("porPrecio");
				if (cursosEncontrados != null) {
					cursosEncontrados.sort(Comparator.comparing(Curso::getPrecio));
					for (Curso c : cursosEncontrados) {
				%>
				<td>
					<%=c.getNombre()%>
				</td>
				<td>
					<%=c.getDuracion()%>
				</td>
				<td>
					<%=c.getPrecio()%>
				</td>
			</tr>
			<%
			}
			}
			%>
		</table>
		<div>
			<a href="menu_gestor_cursos.jsp">VOLVER</a>
		</div>
	</article>
</body>
</html>