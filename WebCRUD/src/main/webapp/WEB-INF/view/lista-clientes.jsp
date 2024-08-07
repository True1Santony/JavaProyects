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
			<th>Modificar</th>
		</tr>
		<c:forEach var="cliente" items="${clientes}">
		
			<c:url var="linkActualizar" value="/cliente/muestraFormularioActualizar">
			
				<c:param name="IdCliente" value="${cliente.id}"/>
			
			</c:url>
		
			<tr>
				<td>${cliente.id}</td>
				<td>${cliente.nombre}</td>
				<td>${cliente.apellidos}</td>
				<td>${cliente.direccion}</td>
				<td>
					<a href="${linkActualizar}"><input type="button" value="Modificar"></a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<input type="button" value="Agregar Cliente" onclick="window.location.href='formularioAgregarCliente'; return false;"/>
	
	<footer style="
        text-align: center;
	    padding: 10px;
	    background-color: #333;
	    color: white !important;
	    position: fixed;
	    bottom: 0;
	    width: 100%;
    ">
        <c:if test="${not empty mensaje}">
            <div class="alert alert-success">
                ${mensaje}
            </div>
        </c:if>
    </footer>

</body>
</html>