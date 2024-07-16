<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/style/estilos.css">
<meta charset="UTF-8">
<title>Confirmación del registro</title>
</head>
<body>

La empresa <b>${laEmpresa.nombre} ${laEmpresa.tipoEmpresa}</b>  se ha registrado correctamente !!!

<p>La localidad es: <b>${laEmpresa.localidad}</b></p>
<p>La Ciudad de la empresa escogida: <b>${laEmpresa.ciudadEmpresa}</b></p>
<p>Los días que se podra atender a la empresa son:  <b>${laEmpresa.diaAtencion}</b></p>

<p><a href="${pageContext.request.contextPath}/">Volver a la página principal</a></p>

</body>
</html>