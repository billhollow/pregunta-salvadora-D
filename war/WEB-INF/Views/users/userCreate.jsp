<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creando una organizacion</title>
<link rel="stylesheet" href="/css/formulario1.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/users">users</a>

	<h1>Creando una organizacion</h1>
	<fieldset>
		<legend> PERFIL </legend>
		<form method="get" action="/users/add">
			<input type="hidden" name="action" value="Created" />
			<p>
				Organizacion: <input type="text" name="organizacion"> 
			</p>
			<p>
				E-MAIL: <input type="email" name="email">
			</p>

			<p>
				<input type="submit" value="enviar datos">
			</p>
		</form>
	</fieldset>
</body>
</html>