<%@page import="model.Producto, java.util.List, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- los siguiente metas son para no- cache -->
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
<title>Carrito</title>
<link rel="stylesheet" href="estilos.css">
</head>
<body>
	<%
	request.getSession();
	%>
	<div class="inicio">
<!-- 		<h2 class="form__title">Carrito</h2> -->
		<div class="form__inputs">
        	<div class="espacio">
				<a class="form__submit"  href="carrito.html">INICIO</a>			
				<a class="form__submit" href="CerrarSessionServlet">CERRAR SESION</a>
			</div>
		</div>
		<div>
		<table>
			<tr>
				<th>PRODUCTO</th>
				<th>PRECIO</th>
				<th>CATEGORIA</th>
				<th>ELIMINAR</th>
			</tr>
			<tr>
				<%
				List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");
				
				if(carrito != null){
				for (Producto p : carrito) {
				%>
				<td><%=p.getNombre()%></td>
				<td><%=p.getPrecio()%></td>
				<td><%=p.getCategoria()%></td>
				<td>
					<a href="EliminarProductoServlet?nombre=<%=p.getNombre()%>">
						<img class="trash" src="images/trash-can.png" />
					</a>
				</td>
			</tr>
			<%
			}}
			%>

		</table>
		</div>		
	</div>
</body>
</html>