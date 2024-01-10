<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: gray;
}

div {
	width: 70%;
	margin: 40px auto;
	background-color: pink;
}

table {
	padding: 20px;
	border: 1px solid yellow;
}
</style>
</head>
<body>
	<div>
		<table>
			<%
			for (int i = 1; i <= 10; i++) {
			%>
			<tr>
				<%
				for (int j = 1; j <= 10; j++) {
				%>
				<td><%=i%> * <%=j%> = <%=i * j%></td>
				<%
				}
				%>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>