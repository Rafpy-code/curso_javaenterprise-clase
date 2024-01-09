<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="service.CuentaBancariaMovimientos"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- los siguiente metas son para no- cache -->
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<title>Banco Rp</title>
</head>
<link rel="stylesheet" href="estilos.css">
</head>
<body>
	<c:if test="${!empty sessionScope.cuenta}">
		<jsp:forward page="cajero.jsp"/>
	</c:if>
	
	<section class="cuenta_inicio">
		<div class="cuenta_inicio__container">
			<img src="cajero.svg" class="modal__img" />
			<div class="modal__texts">
				<form action="CajeroServlet?opcion=1" method="post">
					<div>
						<h2 class="modal__title">Bienvenido al Banco Rp</h2>
						<input type="number" name="saldoInicial"
							placeholder="Saldo inicial" /> 
						<input type="number"
							name="limiteExtraccion" placeholder="Límite de extraccion" /> 
						<input type="submit" 
							class="cta" value="ABRIR CUENTA" />
					</div>
				</form>
			</div>
		</div>
	</section>
	
</body>
</html>