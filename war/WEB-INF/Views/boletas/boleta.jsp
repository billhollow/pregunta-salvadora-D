<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.Product"%>
<%@ page import="model.entity.ElementoBoleta"%>
<%
	List<ElementoBoleta> elementos = (List<ElementoBoleta>) request.getAttribute("elementos");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comprobante de pago</title>
<link rel="stylesheet" href="/css/tabla.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/boleta/add?action=creating">añadir producto</a>
	<a class="b" href="/boleta">GUARDAR BOLETA</a>
	<a class="b" href="/boleta">IMPRIMIR BOLETA</a>

	<div align="center">
		<h1>BOLETA</h1>

		<table>
			<tr>
				<td>Nro de RUC</td>
				<td>Nro de DNI</td>
				<td>Razon social</td>
				<td>Direccion</td>
			</tr>
			<tr>
				<td><input type = "text"></td>
				<td><input type = "text"></td>
				<td><input type = "text"></td>
				<td><input type = "text"></td>
			</tr>
		</table>
		<br><br><br>
		<table>
			<tr>
				<td>nombre</td>
				<td>precio</td>
				<td>cantidad</td>
				<td>total</td>
			</tr>

			<%
				for (int i = 0; i < elementos.size(); i++) {
			%>
			<%
				ElementoBoleta x = (ElementoBoleta) elementos.get(i);
			%>
			<tr>
				<td><%=x.getName()%></td>
				<td><%=x.getPrecio()%> soles</td>
				<td><%=x.getCantidad()%></td>
				<td><%=x.getPrecio() * x.getCantidad()%></td>

				<td><a
					href="boleta/delete?action=deleting&elementoId=<%=x.getId()%>">quitar</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>

</body>
</html>