<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.Product"%>
<%
	Product x = (Product) request.getAttribute("product");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Producto</title>
<link rel="stylesheet" href="/css/tabla.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/products/add?action=creating">CREATE</a>
	<div align="center">
		<h1>DATOS</h1>
		<table>
			<tr>
				<td>ID</td>
				<td><%=x.getId()%></td>
			</tr>

			<tr>
				<td>Nombre</td>
				<td><%=x.getName()%></td>
			</tr>

			<tr>
				<td>Precio</td>
				<td><%=x.getPrecio()%></td>
			</tr>
			<tr>
				<td>Fecha de creacion</td>
				<td><%=x.getDate()%></td>
			</tr>
		</table>
	</div>
</body>
</html>