<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String email = (String) request.getAttribute("email");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logeado</title>
<link rel="stylesheet" href="/css/boton.css">
<link rel="stylesheet" href="/css/formulario1.css">
</head>
<body>
	<h1>
		Hola
		<%=email%>
	</h1>
	<h1>CRUD</h1>

	<a class="b" href="/products">Products</a>
	<a class="b" href="/users">Users</a>
	<a class="b" href="/users/login">Login</a>
	<a class="b" href="/users/logout">Logout</a>
</body>
</html>