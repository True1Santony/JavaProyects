<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Bienvenido</h1>
	
	<hr>
	
	<h3>Ole, hecho</h3>
	
	<p> Usuario: <security:authentication property="principal.username"/>  </p>
	<br/>
	<p> Rol: <security:authentication property="principal.authorities"/> </p>
	
	<!-- Link para administradores -->
	
	<p>
	
	<a href="${pageContext.request.contextPath}/administradores">Administración</a>
	
	</p>
	
	<!-- Link para usuarios -->
		<a href="${pageContext.request.contextPath}/usuarios">Usuarios</a>
	
	
	<p></p>
	
	<!-- Link para administradores -->
	<a href="${pageContext.request.contextPath}/manager">Manager</a>
	<p></p>
	
	
	<form:form action="${pageContext.request.contextPath }/logout" method="POST">
	
		<input type="submit" value="LOGOUT" >
	
	</form:form>

</body>
</html>

<!--
El manejo del logout funciona automáticamente porque **Spring Security** configura una ruta predeterminada para `/logout`.
Esta configuración predeterminada gestiona la invalidación de la sesión y la redirección del usuario a una página de éxito
 o de inicio de sesión después del logout. No es necesario definir un controlador específico 
 para esta ruta si uso **Spring Security**, ya que maneja el proceso de logout por defecto.
-->
