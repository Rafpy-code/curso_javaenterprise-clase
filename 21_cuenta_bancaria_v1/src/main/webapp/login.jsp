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
<title>Login Cuenta Bancaria</title>
<link rel="stylesheet" href="estilos.css">
</head>
<body>
	<a href="#target" class="cta">Banco Rp</a>	
	<section class="modal" id="target">
		<div class="modal__container">
			<a href="#" class="modal__close">X</a> 
			<img src="cajero.svg" class="modal__img" />
			<div class="modal__texts">
				<form action="LoginServlet" method="post">
					<%if (request.getParameter("usuario").equals("error")) {%>
					<div class="alert alert-danger" role="alert">Compruebe los
						datos!</div>
					<%}%>
					<div>
						<h2 class="modal__title">Banco Rp</h2>
						<input type="text" name="usuario" placeholder="Ingrese su usuario" />
						<input type="password" name="password"
							placeholder="Ingrese su contraseña" />
						<div class="check_label">
							<label>Recordar Usuario:</label> <input type="checkbox"
								name="recordar" value="1" />
						</div>
						<input type="submit" class="cta" value="Acceder" />
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>
