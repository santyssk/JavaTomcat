<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<link href="/css/format.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("username")==null){
			response.sendRedirect("login.jsp");
		}
	%>
	Welcome ${username}!!!
	<br>
	<form action="Logout">
		<input type="submit" value="Logout">
	</form>
</body>
</html>