<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabla de multiplicar</title>
<style type="text/css">
h1{
text-align: center;
color: purple;
}
table {
	margin: 50px auto;
	border: 1px solid blue;
}
</style>
</head>
<body>
	<%int numero=Integer.parseInt(request.getParameter("numero"));%>
	<h1>
		Tabla del <%=numero%></h1>
	<table>
		<%for(int i=0;i<=10;i++){%>
		<tr>
			<td><%=i%> * <%=numero%> = <%=i*numero%></td>
		</tr>
		<%}%>
	</table>
</body>
</html>