<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Santhosh Kumar</title>
<link href="/css/format.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="BasicCalculator">
		Enter a valid arithmetic expression : <input type="text" name="expression"><br><br>
		<input type="submit" value="Calculate"><br><br>
		The value of the expression ${question} is <span id="result">${value}</span>
	</form></body>
</html>