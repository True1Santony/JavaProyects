<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Propio</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .login-container {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }

        .login-container h3 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .login-container p {
            margin: 10px 0;
        }

        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        .login-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #007bff;
            color: white;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .login-container input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .formatoError {
            color: red;
            font-size: 14px;
            margin-bottom: 10px;
            display: block;
            text-align: center;
        }
        
        .formatoLogout {
            color: green;
            font-size: 15px;
            margin-bottom: 10px;
            display: block;
            text-align: center;
        }
    </style>

</head>
<body>

<div class="login-container">
    <h3>Pagina de Login</h3>

    <form:form action="${pageContext.request.contextPath }/autenticacionUsuario" method="POST">

        <c:if test="${param.error != null}">
            <span class="formatoError">Usuario o contraseña incorrecto</span>
        </c:if>
        
        <c:if test="${param.logout != null}">
            <span class="formatoLogout">Se ha cerrado sesion</span>
        </c:if>

        <p>Usuario:</p>
        <input type="text" name="username" required="required"/>

        <p>Contraseña:</p>
        <input type="password" name="password" required="required"/>

        <input type="submit" value="Login"/>
    </form:form>
</div>

</body>
</html>
