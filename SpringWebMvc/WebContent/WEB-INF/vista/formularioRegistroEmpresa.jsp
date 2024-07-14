<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>     
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/style/estilos.css">
<meta charset="UTF-8">
<title>Formulario registro Empresas</title>
</head>
<body>
    <h2>Registro de Empresa</h2>
    <form:form action="${pageContext.request.contextPath}/empresa/muestraFormularioProcesado" modelAttribute="laEmpresa">
        <table>
            <tr>
                <td>Nombre de la Empresa:</td>
                <td><form:input path="nombre"/></td>
            </tr>
            <tr>
                <td>Tipo de Empresa:</td>
                <td><form:input path="tipoEmpresa"/></td>
            </tr>
            <tr>
                <td>Localidad:</td>
                <td><form:select path="localidad">
                		<form:option value="Madrid" lable="Madrid"/>
                		<form:option value="Barcelona" lable="Barcelona"/>
                		<form:option value="Galicia" lable="Galicia"/>
                		<form:option value="Leon" lable="Leon"/>
                		<form:option value="Toledo" lable="Toledo"/>
                		<form:option value="Palencia" lable="Palencia"/>
                		<form:option value="Valencia" lable="Valencia"/>
                	</form:select> 
                </td>
            </tr>
            <tr>
                <td>
                	<input type="submit" value="Registrar"/>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>