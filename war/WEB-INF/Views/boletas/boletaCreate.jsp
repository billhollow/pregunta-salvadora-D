<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.*"%>
<%@ page import="java.util.List"%>
<% List<Product> productos = (List<Product>)request.getAttribute("productos"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>añadiendo producto a la boleta</title>
<link rel="stylesheet" href="/css/formulario1.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/boleta">boleta</a>

	<h1>añadiendo producto a la boleta</h1>
	<fieldset>
		<legend> DATA </legend>
		<form method="get" action="/boleta/add">
		 <input type="hidden" name="action" value="Created"/>
			Productos: <select name="producto">
			<% for(int i = 0; i<productos.size(); i++){ %>
				<option value="<%=productos.get(i).getName()%>"> <%=productos.get(i).getName()%></option>
			<%} %>
			</select>
			Cantidad: <input type="text" name="cantidad" >
			<p>
				<input type="submit" value="enviar datos">
			</p>
		</form>
	</fieldset>
</body>
</html>