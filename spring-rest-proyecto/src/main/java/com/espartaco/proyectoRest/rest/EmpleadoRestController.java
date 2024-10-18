package com.espartaco.proyectoRest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.espartaco.proyectoRest.entidad.Empleado;

@RestController
@RequestMapping("/api")
public class EmpleadoRestController {
	
	private List<Empleado> losEmpleados;

	@GetMapping("/empleados")
	public List<Empleado> getEmpleados(){
		
		System.out.println("2. Paso por @GetMapping");
		return losEmpleados;
		
	}
	
	
	/**
	 * Carga en memoria lo necesario tras construir los Beans y realizar las 
	 * inyecciones de dependencias.
	 * Una vez cargado, cada vez que se consulte a los empleados no se vuelven a cargar, ya 
	 * lo estan en memoria
	 */
	@PostConstruct
	public void cargarDatos() {
		
		losEmpleados= new ArrayList<>();
		
		losEmpleados.add(new Empleado("Espartaco", "Nassekine"));
		
		losEmpleados.add(new Empleado("Marcos", "Lopez"));
		
		losEmpleados.add(new Empleado("Pablo", "Martinez"));
		
		losEmpleados.add(new Empleado("Amanda", "Hernando"));
		
		losEmpleados.add(new Empleado("Sofia", "Checo"));
		
		System.out.println("1. Paso por PostConstruct");
		
	}
	
	@GetMapping("/empleados/{posicionEmpleado}")
	public Empleado getEmpleado(@PathVariable int posicionEmpleado) {
		
		//comprueba si existe el empleado
		
		if(posicionEmpleado>=losEmpleados.size() || posicionEmpleado<0) {
			
			throw new EmployerNotFoundError("el ID"+posicionEmpleado+"no existe" );
			
		}
		
		return losEmpleados.get(posicionEmpleado);
		
		//Clase de respuesta http, cuerpo, estado..
		
		
		
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployerResponseError> manejoExcepcionEmpleado(EmployerNotFoundError ex){
		
		EmployerResponseError error = new EmployerResponseError();
		
		error.setEstado(HttpStatus.NOT_FOUND.value());
		error.setDescripcion(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
	// Nuevo manejador de excepción para cuando el PathVariable no es un entero
    @ExceptionHandler
    public ResponseEntity<EmployerResponseError> manejoExcepcionTipo(MethodArgumentTypeMismatchException ex) {
        EmployerResponseError error = new EmployerResponseError();
        error.setEstado(HttpStatus.BAD_REQUEST.value());
        error.setDescripcion("El parámetro '" + ex.getValue() + "' no es válido. Debe ser un número entero.");
        error.setTimeStamp(System.currentTimeMillis());
        
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
	
}
