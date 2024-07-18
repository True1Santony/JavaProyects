<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/res/style/estilos.css">
<meta charset="UTF-8">
<title>Formulario registro Empresas</title>
</head>
<body>
	<h2>Registro de Empresa</h2>
	<form:form
		action="${pageContext.request.contextPath}/empresa/muestraFormularioProcesado"
		modelAttribute="laEmpresa">
		<table>
			<tr>
				<td>Nombre de la Empresa:</td>
				<td><form:input path="nombre" /></td>
				<td><form:errors path="nombre" style="color:red" /></td>

			</tr>
			<tr>
				<td>Tipo de Empresa:</td>
				<td><form:input path="tipoEmpresa" /></td>
			</tr>
			<tr>
				<td>Localidad:</td>
				<td><form:select path="localidad">
						<form:option value="Madrid" label="Madrid" />
						<form:option value="Barcelona" label="Barcelona" />
						<form:option value="Galicia" label="Galicia" />
						<form:option value="Leon" label="Leon" />
						<form:option value="Toledo" label="Toledo" />
						<form:option value="Palencia" label="Palencia" />
						<form:option value="Valencia" label="Valencia" />
					</form:select></td>
			</tr>

			<tr>
				<td>Código postal:</td>
				<td><form:input path="direccion.codigoPostal" /></td>
				<td><form:errors path="direccion.codigoPostal" style="color:red" /></td>
			</tr>

			<tr>
				<td><b>Seleccione la Ciudad:_____________________________</b></td>
				<td><b>_____________________</b></td>
			</tr>
			<tr>
				<td>Barcelona:</td>
				<td><form:radiobutton path="ciudadEmpresa" value="Barcelona" /></td>
			</tr>
			<tr>
				<td>Madrid:</td>
				<td><form:radiobutton path="ciudadEmpresa" value="Madrid" /></td>
			</tr>
			<tr>
				<td>Galicia:</td>
				<td><form:radiobutton path="ciudadEmpresa" value="Galicia" /></td>
			</tr>
			<tr>
				<td>Leon:</td>
				<td><form:radiobutton path="ciudadEmpresa" value="Leon" /></td>
			</tr>
			<tr>
				<td>Toledo:</td>
				<td><form:radiobutton path="ciudadEmpresa" value="Toledo" /></td>
			</tr>

			<tr>
				<td><b>Seleccione los dias de atención:___________________</b></td>
				<td><b>_____________________</b></td>
			</tr>
			<tr>
				<td>Lunes: <form:checkbox path="diaAtencion" value="Lunes" />
					Martes: <form:checkbox path="diaAtencion" value="Martes" />
					Miercoles: <form:checkbox path="diaAtencion" value="Miercoles" />
					Jueves: <form:checkbox path="diaAtencion" value="Jueves" />
					Viernes: <form:checkbox path="diaAtencion" value="Viernes" />
				</td>
			</tr>

			<tr>
				<td>Nombre Contacto:</td>
				<td><form:input path="contactoEmpresa.nombre" /></td>
				<td><form:errors path="contactoEmpresa.nombre" style="color:red" /></td>
			</tr>
			<tr>
				<td>Email Contacto:</td>
				<td><form:input path="contactoEmpresa.mail" /></td>
				<td><form:errors path="contactoEmpresa.mail" style="color:red" /></td>
			</tr>
			<tr>
				<td>Edad Contacto:</td>
				<td><form:input path="contactoEmpresa.edad" /></td>
				<td><form:errors path="contactoEmpresa.edad" style="color:red" /></td>
			</tr>


			<tr>
				<td><input type="submit" value="Registrar" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>