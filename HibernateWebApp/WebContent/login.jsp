<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" buffer="16kb" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
<%@ include file = "header.html" %>
<form action="LoginController" method="post">
		<p><input type="text" name ="username" placeholder ="Enter Username"></p>
		<p><input type ="password" name = "passwd" placeholder = "Enter Password"></p>
		<p><input type = "submit" value ="sign In"></p>
	</form>
	<%@ include file = "footer.html" %>
</body>
</html>