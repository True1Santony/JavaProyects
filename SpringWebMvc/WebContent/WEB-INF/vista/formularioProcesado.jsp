<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/res/style/estilos.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	Hola ${param.nombreEmpresa}. vamos a personalizar tu presupuesto

	<h2>Benvenida a:</h2>

	${empresaNueva}
	<p />

	<img class="img-reducida" alt="foto"
		src="${pageContext.request.contextPath}/res/images/hoja.jpg">

	<!-- Agregar un enlace a la página index -->
	<p>
		<a href="${pageContext.request.contextPath}/">Volver a la página
			principal</a>
	</p>


</body>
</html>