<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%for (int i = 1; i <= 6; i++) {%>
		<h<%=i%>>Primera Java Server Page</h<%=i%>>
		<%}%>
	</div>
</body>
</html>