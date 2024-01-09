<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.*, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lista de cursos por precio</title>
<link rel="stylesheet" href="menu_gestor_cursos.css" />
</head>
<body>
	<%
		request.getSession();
	%>
	<article class="lista_cursos">
		<h1>Lista de cursos obtenidos</h1>
		<table border="1px">
			<tr>
				<th>CURSO</th>
				<th>DURACIÓN</th>
				<th>PRECIO</th>
			</tr>
			<tr>
				<%
				List<Curso> cursosOriginal = (List)session.getAttribute("listaCursos");
				if (cursosOriginal != null) {
					//System.out.println("primer-if");
					for (Curso c : cursosOriginal) {
						//System.out.println("primer-for -> "+c.getNombre()+"-"+c.getDuracion());
						//System.out.println("cursosOriginal-> "+ c.getNombre());
						if (c.getPrecio() <= Double.parseDouble(request.getParameter("precio"))) {
							//System.out.println("segundo-if");
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
			}
			%>
		</table>
		<div>
			<a href="menu_gestor_cursos.jsp">VOLVER</a>
		</div>
	</article>
</body>
</html>