<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.Product"%>
<% List<Product> products = (List<Product>)request.getAttribute("products"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vista productos</title>
<link rel="stylesheet" href="/css/tabla.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/products/add?action=creating">CREATE</a>

<div align="center">
<h1> Productos </h1>
<table>
	<tr>	  	
		<td>ID</td>
		<td>nombre</td>
		<td>precio</td>
		<td>Fecha creada</td>
	</tr>
<% for (int i = 0;i<products.size();i++){ %>
<% Product x = (Product)products.get(i); %>
<tr>
	<td> <%= x.getId()%> </td>
	<td> <%= x.getName() %> </td>
	<td> <%= x.getPrecio() %> soles </td>
	<td> <%= x.getDate() %> </td>

	<td><a href="products/view?action=reading&productId=<%=x.getId()%>">view </a></td>
	<td><a href="products/update?action=updating&productId=<%=x.getId()%>">update</a></td>
	<td><a href="products/delete?action=deleting&productId=<%=x.getId()%>">delete</a></td>
</tr>
<% } %>
</table>
</div>

</body>
</html>