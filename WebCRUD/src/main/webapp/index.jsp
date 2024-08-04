<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/style/IndexStyle.css">
</head>
<body>

<div class="header">
    <img src="${pageContext.request.contextPath}/res/images/inicio.jpg" alt="Inicio">
</div>

<div class="nav">
    <a href="#">Clientes</a>
    <a href="#">Proyectos</a>
    <a href="#">Contacto</a>
    <a href="#">Perfil</a>
</div>

<div class="content">
    <h2>Sobre Nosotros</h2>
    <p>
        Nuestra empresa se especializa en la creación de presupuestos para obras públicas y privadas.
        Ofrecemos servicios de alta calidad y precisión para asegurar que sus proyectos se realicen
        de acuerdo con los costos planificados y sin sorpresas. Nuestro equipo de expertos está
        comprometido con la excelencia y la satisfacción del cliente.
    </p>
</div>

<div class="footer">
    <a href="${pageContext.request.contextPath}/cliente/lista">Ver lista de clientes</a>
</div>

</body>
</html>
