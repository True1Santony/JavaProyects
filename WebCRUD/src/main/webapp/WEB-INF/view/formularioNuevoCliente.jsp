<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value='/res/style/style.css' />">
<title>Formulario Agregar Cliente Nuevo</title>
</head>
<body>

	<h2>Inserte los datos del nuevo cliente</h2>

	<form:form action="insertarCliente" modelAttribute="cliente" method="POST">
	
		<form:hidden path="id" />
		
			<table>
					
					<tr>
						<td>Nombre: </td>
						<td><form:input path="nombre"/></td>
					</tr>
					
					<tr>
						<td>Apellidos: </td>
						<td><form:input path="apellidos"/></td>
					</tr>
					
					<tr>
						<td>Direccion: </td>
						<td><form:input path="direccion"/></td>
					</tr>
					
					<td colspan="2"><input type="submit" value="Insertar"></td>
			
			
			</table>
	
	
	</form:form>

</body>
</html>