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
<title>Error Login MVC</title>
<link rel="stylesheet" href="estilos.css" />
</head>
<body>
	<div>
		<h3 style="color: red">
			El usuario [<%=request.getParameter("usuario")%>]
			es incorrecto!
		</h3>
		<h3 style="color: red">
			La contraseña {<%=request.getParameter("password")%>} es incorrecta!
		</h3>
		<a href="FrontController?operation=toLogin">LOGIN</a>
	</div>
</body>
</html>

