<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página de Inicio</title>
    <style>
        /* Estilo para la página web */
        body {
            margin: 0;
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
        }

        header {
            background-color: #3498db;
            color: white;
            text-align: center;
            padding: 20px 0;
        }

        header h1 {
            margin: 0;
            font-size: 2.5rem;
        }

        nav {
            text-align: center;
            margin-top: 20px;
        }

        nav a {
            text-decoration: none;
            color: #3498db;
            margin: 0 15px;
            font-size: 1.2rem;
        }

        nav a:hover {
            color: #2c3e50;
        }

        .hero {
            background-image: url('https://via.placeholder.com/1500x600');
            background-size: cover;
            background-position: center;
            height: 60vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .hero h2 {
            color: white;
            font-size: 3rem;
            text-shadow: 2px 2px 10px rgba(0, 0, 0, 0.5);
        }

        .content {
            text-align: center;
            padding: 50px 20px;
        }

        .content h3 {
            font-size: 2rem;
            color: #3498db;
        }

        .content p {
            font-size: 1.2rem;
            color: #7f8c8d;
            max-width: 800px;
            margin: 20px auto;
            line-height: 1.6;
        }

        footer {
            background-color: #2c3e50;
            color: white;
            text-align: center;
            padding: 10px 0;
            margin-top: 50px;
        }

        footer p {
            margin: 0;
        }

        footer a {
            color: #3498db;
            text-decoration: none;
        }

        footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <header>
        <h1>Bienvenido a Mi Página Web</h1>
    </header>

    <nav>
        <a href="#">Inicio</a>
        <a href="empleados.jsp">Empleados</a>
        <a href="#">Acerca de</a>
        <a href="#">Contacto</a>
    </nav>

    <section class="hero">
        <h2>Explora nuestro mundo</h2>
    </section>

    <section class="content">
        <h3>Acerca de Nosotros</h3>
        <p>Somos una compañía dedicada a proveer los mejores servicios a nuestros clientes. Con años de experiencia en la industria, ofrecemos soluciones adaptadas a cada necesidad. Nuestro equipo se esfuerza por asegurar la satisfacción total de nuestros usuarios.</p>
        <a href="prueba/saludo">ir a página de prueba(ruta relativa)</a>
        <p></p>
        <a href ="${pageContext.request.contextPath}/prueba/saludo">ruta con context Path</a>
        
    </section>

    <footer>
        <p>&copy; 2024 Mi Página Web. Todos los derechos reservados. <a href="#">Política de Privacidad</a></p>
    </footer>

</body>
</html>
