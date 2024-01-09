<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.List, model.*, 
	service.CuentaBancariaMovimientos, service.TipoMovimiento"%>
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
<body>
	<header>
		<nav>
			<a href="#ingresar" class="cta" >Ingresar</a>
			<a href="#extraer" class="cta" >Retirar</a>
			<a href="#movimientos" class="cta" >Movimientos</a>
			<a href="login.jsp?usuario=''" class="cta" >Salir</a>
		</nav>
	</header>
	<section class="modal" id="ingresar">
		<div class="modal__container">
		<a href="#" class="modal__close">X</a> 
			<img src="cajero.svg" class="modal__img" />
			<div class="modal__texts">
				<form action="CajeroServlet?opcion=2" method="post">
					<div>
						<h2 class="modal__title">Banco Rp</h2>
						<input type="number" name="ingresar" placeholder="Cantidad a ingresar" />
						<input type="submit" class="cta" value="INGRESAR" />
					</div>
				</form>
			</div>
		</div>
	</section>
	<section class="modal" id="extraer">
		<div class="modal__container">
		<a href="#" class="modal__close">X</a> 
			<img src="cajero.svg" class="modal__img" />
			<div class="modal__texts">
				<form action="CajeroServlet?opcion=3" method="post">
					<div>
						<h2 class="modal__title">Banco Rp</h2>
						<input type="text" value="LÍMITE DE RETIRO: ${param.limiteExtraccion }" readonly />						
						<input type="number" name="extraer" placeholder="Cantidad a retirar" />
						<input type="submit" class="cta" value="RETIRAR" />
					</div>
				</form>
			</div>
		</div>
	</section>
	<section class="modal" id="movimientos">
		<div class="modal__container">
		<a href="#" class="modal__close">X</a> 
			<img src="cajero.svg" class="modal__img" />
			<div class="modal__texts">
				<form action="cajero.jsp" method="post">
					<div>
						<h2 class="modal__title">Banco Rp</h2>
						<c:if test="${!empty sessionScope.cuenta}">
						<table>
							<tr>							
								<th class="saldo_limite">Saldo</th>
								<th class="saldo_valor">${cuenta.saldo}</th>
								<th class="saldo_limite">Límite diario</th>
								<th class="saldo_valor">${cuenta.limite}</th>
							</tr>
						</c:if>							
							<tr>
								<th>Nº</th>
								<th>CANTIDAD</th>
								<th>FECHA</th>
								<th>TIPO</th>
							</tr>
 							
 							<c:if test="${!empty sessionScope.movimientos}">
 							<c:forEach var="movimientos" items="${sessionScope.movimientos}" varStatus="indice" >
 							<tr>		
 								<!-- movimientos.tipo.equals(TipoMovimiento.EXTRACCION) -->						
							<c:choose>								
								<c:when test="${movimientos.tipo.equals(TipoMovimiento.EXTRACCION)}">
									<td class="extraccion">${indice.index+1}</td>
									<td class="extraccion">${movimientos.cantidad}</td>
									<c:set var="fecha" value="${movimientos.formatearFechaHoraAmigable(movimientos.fechaHora)}"/>
									<td class="extraccion">${fecha}</td>
									<td class="extraccion">${movimientos.tipo}</td>
								</c:when>
								<c:otherwise>
									<td>${indice.index+1}</td>
									<td>${movimientos.cantidad}</td>
<%-- 									<%String fechaHora =c.formatearFechaHoraAmigable(movimientos.get(i).getFechaHora()); %> --%>
									<c:set var="fecha" value="${movimientos.formatearFechaHoraAmigable(movimientos.fechaHora)}"/>
									<td>${fecha}</td>
									<td>${movimientos.tipo}</td>
								</c:otherwise>
							</c:choose>		
							</tr>
							</c:forEach>
 							</c:if>
						</table>
						<input type="submit" class="cta" value="INICIO" />
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>