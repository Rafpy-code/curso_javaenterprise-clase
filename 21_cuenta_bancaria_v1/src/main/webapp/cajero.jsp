<%@page import="service.TipoMovimiento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.List, model.*, 
	service.CuentaBancariaMovimientos"%>
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
	<%request.getSession(); %>
	<%CuentaBancariaMovimientos c = (CuentaBancariaMovimientos)request.getSession().getAttribute("cuenta"); %>
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
						<input type="text" value="LÍMITE DE RETIRO: <%=c.getLimite()%>" readonly />						
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
						<table>
							<tr>							
								<th class="saldo_limite">Saldo</th>
								<th class="saldo_valor"><%=c.getSaldo() %></th>
								<th class="saldo_limite">Límite diario</th>
								<th class="saldo_valor"><%=c.getLimite() %></th>
							</tr>							
							<tr>
								<th>Nº</th>
								<th>CANTIDAD</th>
								<th>FECHA</th>
								<th>TIPO</th>
							</tr>
 							<%
 								List<Movimiento> movimientos = (List)request.getSession().getAttribute("movimientos");
 								if (movimientos != null) {
 									for(int i = 0; i<movimientos.size();i++){
 							%>
 							<tr>								
								<%if(movimientos.get(i).getTipo().equals(TipoMovimiento.EXTRACCION)){%>
									<td class="extraccion"><%=i+1%></td>
									<td class="extraccion"><%=movimientos.get(i).getCantidad()%></td>
									<%String fechaHora =c.formatearFechaHoraAmigable(movimientos.get(i).getFechaHora()); %>
									<td class="extraccion"><%=fechaHora %></td>
									<td class="extraccion"><%=movimientos.get(i).getTipo()%></td>
								<%}else {%>
									<td><%=i+1%></td>
									<td><%=movimientos.get(i).getCantidad()%></td>
									<%String fechaHora =c.formatearFechaHoraAmigable(movimientos.get(i).getFechaHora()); %>
									<td><%=fechaHora %></td>
									<td><%=movimientos.get(i).getTipo()%></td>
								<%}%>									
							</tr>
 							<%}}%>
						</table>
						<input type="submit" class="cta" value="INICIO" />
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>