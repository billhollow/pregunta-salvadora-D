<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.User"%>
<% List<User> users = (List<User>)request.getAttribute("users"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vista usuarios</title>
<link rel="stylesheet" href="/css/tabla.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/users/add?action=creating">CREATE</a>

<div align="center">
<h1> Usuarios </h1>
<table>
	<tr>	  	
		<td>ID</td>
		<td>organizacion</td>
		<td>e-mail</td>
		<td>Fecha creada</td>
	</tr>
<% for (int i = 0;i<users.size();i++){ %>
<% User x = (User)users.get(i); %>
<tr>
	<td> <%= x.getId()%> </td>
	<td> <%= x.getOrganizacion() %> </td>
	<td> <%= x.getEmail() %> </td>
	<td> <%= x.getDate() %> </td>

	<td><a href="users/view?action=reading&userId=<%=x.getId()%>">view </a></td>
	<td><a href="users/update?action=updating&userId=<%=x.getId()%>">update</a></td>
	<td><a href="users/delete?action=deleting&userId=<%=x.getId()%>">delete</a></td>
</tr>
<% } %>
</table>
</div>

</body>
</html>