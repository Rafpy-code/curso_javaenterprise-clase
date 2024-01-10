<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- los siguiente metas son para no- cache -->
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
<title>Gestor de cursos con Login</title>
<link rel="stylesheet" href="login.css" />
</head>
<body>
	<form action="LoginServlet" method="post">
		<div>
			<%if(request.getParameter("usuario").equals("error")) {%>
			<div>
				<span>***** Datos incorrectos *****</span>
			</div>		
			<%}%>
				<h2>Login</h2>
				<input type="text" name="usuario" placeholder="Ingrese su usuario" />
				<input type="password" name="password"
					placeholder="Ingrese su contraseña" /> 
			
				<div class="check_label">
					<label>Recordar	Usuario:</label> 
					<input type="checkbox" name="recordar" value="1" /> 
				</div>
				<input type="submit" value="Entrar" />
		</div>
	</form>
</body>
</html>