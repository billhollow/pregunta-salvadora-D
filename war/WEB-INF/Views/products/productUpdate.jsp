<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.Product"%>
<%@ page import="java.util.List"%>
<%
	Product product = (Product) request.getAttribute("product");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Updating</title>
<link rel="stylesheet" href="/css/formulario1.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/products/add?action=creating">CREATE</a>

	<h1>Updating</h1>
	<form method="get" action="/products/update">
		<input type="hidden" name="action" value="Updated" /> <input
			type="hidden" name="productId" value="<%=product.getId()%>" />
		<fieldset>
			<legend> Nuevos datos </legend>

			<p>
				Nombre: <input type="text" name="name" value="<%=product.getName() %>">
			</p>
			<p>
				Precio: <input type="text" name="precio" value="<%=product.getPrecio() %>"> soles
			</p>

			<p>
				<input type="submit" value="enviar datos">
			</p>

		</fieldset>
	</form>
</body>
</html>