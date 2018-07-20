<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creando un producto</title>
<link rel="stylesheet" href="/css/formulario1.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/products">productos</a>

	<h1>Creando un producto</h1>
	<fieldset>
		<legend> Datos </legend>
		<form method="get" action="/products/add">
			<input type="hidden" name="action" value="Created" />
			<p>
				Nombre del producto: <input type="text" name="name"> 
			</p>
			<p>
				Precio del producto: <input type="text" name="precio"> soles
			</p>

			<p>
				<input type="submit" value="enviar datos">
			</p>
		</form>
	</fieldset>
</body>
</html>