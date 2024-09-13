<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Propio</title>
</head>
<body>

<h3 style="text-align:center">Pagina de login</h3>

<form:form action="${pageContext.request.contextPath }/autenticacionUsuario" method="POST">

	<p>
		Usuario:<input type="text" name="username" required="required"/>	
	</p>
	
	<p>
		Contraseña:<input type="password" name="password" required="required"/>	
	</p>
	
	
	<input type="submit" value="Login"/>

</form:form>


</body>
</html>