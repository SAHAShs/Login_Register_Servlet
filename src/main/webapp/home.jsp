<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<span><a href="index.jsp">Log out >>>>></a></span>
	<h1>
		Welcome<%
	String errorMessage = (String) request.getAttribute("name");
	if (errorMessage != null && !errorMessage.isEmpty()) {
	%>
		<%=errorMessage%>
		<%
		}
		%>
	</h1>
</body>
</html>