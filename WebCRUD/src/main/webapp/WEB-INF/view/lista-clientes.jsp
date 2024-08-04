<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>lista clientes</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/res/style/style.css' />">
</head>

<body>

	<h2>Lista de todos los clientes</h2>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Dirección</th>
		</tr>
		<c:forEach var="cliente" items="${clientes}">
			<tr>
				<td>${cliente.id}</td>
				<td>${cliente.nombre}</td>
				<td>${cliente.apellidos}</td>
				<td>${cliente.direccion}</td>
			</tr>
		</c:forEach>
	</table>
	
	<input type="button" value="Agregar Cliente" onclick="window.location.href='formularioAgregarCliente'; return false;"/>

</body>
</html>