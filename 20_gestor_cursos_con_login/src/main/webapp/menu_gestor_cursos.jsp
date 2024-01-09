<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Curso, model.Usuario, java.util.List, service.CursosService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Menu gestor cursos</title>
<link rel="stylesheet" href="menu_gestor_cursos.css" />
</head>
<body>
	<%
	request.getSession();
	CursosService cursosService = new CursosService();
	%>
	<header>
		<h1>GESTOR DE CURSOS</h1>
		<h3>Bienvenido PONER USUARIO</h3>
	</header>
	<main>		
		<aside>
			<a href="#nuevoCurso.jsp">AGREGAR NUEVO CURSO</a>
			<a href="#modificarDuracion.jsp">MODIFICAR DURACION DEL CURSO</a>
			<a href="#cursosPrecioMax.jsp">LISTA DE CURSOS POR PRECIO MÁXIMO</a>
			<a href="#eliminarCurso.jsp">ELIMINAR CURSO</a>
			<div>
				<a href="login.jsp?usuario="<%=""%>>SALIR</a>
			</div>
		</aside>
		<section>
			<article id="nuevoCurso.jsp">
				<h1>Agregar nuevo curso</h1>
				<form action="GestorCursosServlet?opcion=1" method="post">
				<input type="text" name="nombre" placeholder="Nombre del curso">
				<input type="text" name="duracion" placeholder="Duracion del curso [350]">
				<input type="text" name="precio" placeholder="Precio del curso [350.69]">
				<input type="submit" value="GUARDAR">
				<div>
					<a href="#">VOLVER</a>
				</div>
				</form>
			</article>
			<article id="modificarDuracion.jsp">
				<form  action="GestorCursosServlet?opcion=2" method="post">
				<h1>Nueva duracción del curso</h1>
				<input type="text" name="nombre" placeholder="Nombre del curso">
				<input type="text" name="duracion" placeholder="Duracion del curso">
				<input type="submit" value="MODIFICAR">
				<div>
					<a href="#">VOLVER</a>
				</div>
				</form>
			</article>
			<article id="cursosPrecioMax.jsp">
				<form action="#cursosPrecioMax.jsp" method="post">
				<h1>Consultar cursos por precio máximo</h1>
				<input type="text" name="precio" placeholder="Precio del curso">
				<input type="submit" value="CONSULTAR">
				<div>
					<a href="#">VOLVER</a>
				</div>
				</form>
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
							//(List<Curso>)session.getAttribute("listaCursos");
								//double precio = Double.parseDouble(request.getParameter("precio"));
								List<Curso> cursos = (List<Curso>)session.getAttribute("listaCursos");
								if(cursos != null){
									for(Curso c : cursos){
										if(c.getPrecio()<= Double.parseDouble(request.getParameter("precio"))){
							%>						
							<td><%c.getNombre();%></td>
							<td><%c.getDuracion();%></td>
							<td><%c.getPrecio();%></td>
						</tr>	
						<%}}}%>					
					</table>
				</article>
			</article>
			<article id="eliminarCurso.jsp">
				<form action="GestorCursosServlet?opcion=4" method="post">
				<h1>Eliminar curso</h1>
				<input type="text" name="nombre" placeholder="Nombre del curso">
				<input type="submit" value="ELIMINAR">
				<div>
					<a href="#">VOLVER</a>
				</div>
				</form>
			</article>
		</section>		
	</main>	
</body>
</html>
