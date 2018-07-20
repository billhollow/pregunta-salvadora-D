<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.User"%>
<%@ page import="java.util.List"%>
<%
	User user = (User) request.getAttribute("user");
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
	<a class="b" href="/users/add?action=creating">CREATE</a>

	<h1>Updating</h1>
	<form method="get" action="/users/update">
		<input type="hidden" name="action" value="Updated" /> <input
			type="hidden" name="userId" value="<%=user.getId()%>" />
		<fieldset>
			<legend> Nuevos datos </legend>

			<p>
				Organizacion: <input type="text" name="organizacion" value="<%=user.getOrganizacion() %>">>
			</p>

			<p>
				<input type="submit" value="enviar datos">
			</p>

		</fieldset>
	</form>
</body>
</html>