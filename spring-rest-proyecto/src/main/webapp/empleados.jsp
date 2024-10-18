<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Empleados</title>
    <style>
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 50px 0;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
    <h1>Lista de Empleados</h1>

    <table>
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Apellido</th>
            </tr>
        </thead>
        <tbody id="empleados">
            <!-- Los empleados serán insertados aquí dinámicamente -->
        </tbody>
    </table>

    <script>
        // Función que llama a la API y carga los empleados en la tabla
        async function cargarEmpleados() {
            try {
                const response = await fetch('http://localhost:8088/spring-rest-proyecto/api/empleados');
                const empleados = await response.json();

                const tablaEmpleados = document.getElementById('empleados');
                tablaEmpleados.innerHTML = ''; // Limpiamos la tabla antes de llenarla

                // Iterar sobre los empleados y crear las filas
                empleados.forEach(empleado => {
                    const fila = document.createElement('tr');

                    const columnaNombre = document.createElement('td');
                    columnaNombre.textContent = empleado.nombre;

                    const columnaApellido = document.createElement('td');
                    columnaApellido.textContent = empleado.apellido;

                    fila.appendChild(columnaNombre);
                    fila.appendChild(columnaApellido);
                    tablaEmpleados.appendChild(fila);
                });
            } catch (error) {
                console.error('Error al cargar los empleados:', error);
            }
        }

        // Cargar empleados cuando se carga la página
        window.onload = cargarEmpleados;
    </script>
</body>
</html>
