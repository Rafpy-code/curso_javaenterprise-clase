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
<title>Formulario de login</title>
<link rel="stylesheet" href="estilos.css">
</head>
<body>
	<%request.getSession();%>
	<form class="form" action="LoginServlet" method="post">
		<section class="form__register">
			<h2 class="form__title">Login</h2>
			<div class="form__inputs">
				<div class="form__group">
					<input class="form__input" type="text" name="usuario" id="usuario" placeholder=" ">
					<label class="form__label" >Usuario</label> 
					<span class="form__bar"></span>
				</div>
				<div class="form__group">
					<input class="form__input" type="password" name="password" id="password" placeholder=" "> 
					<label class="form__label">Password</label> 
					<span class="form__bar"></span>
				</div>
				<input class="form__submit" type="submit" value="Ingresar">
			</div>
		</section>
		<section class="form__picture"></section>
	</form>
</body>
</html>