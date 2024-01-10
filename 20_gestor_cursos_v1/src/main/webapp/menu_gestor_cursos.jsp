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
	// Obtener la sesión
   	request.getSession(false);
	String username = request.getParameter("usuario");
    // Verificar si la sesión existe y contiene el atributo 'usuario'
    if (session != null && session.getAttribute("usuario") != null) {
        username = (String) session.getAttribute("usuario");
    } else {
        // Si la sesión no existe o no contiene el atributo 'usuario', redirigir a la página de inicio de sesión
        response.sendRedirect("login.jsp");
    }
	%>
	<header>
		<h1>GESTOR DE CURSOS</h1>
		<h3>Bienvenido <%=username%></h3>
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
			<article>
				<h1 class="centrado">GESTOR DE CURSOS V.1</h1>
			</article>
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
				<form action="ListaCursosPrecio.jsp" method="post">
				<h1>Consultar cursos por precio máximo</h1>
				<input type="text" name="precio" placeholder="Precio del curso">
				<input type="submit" value="CONSULTAR">
				<div>
					<a href="#">VOLVER</a>
				</div>
				</form>				
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
