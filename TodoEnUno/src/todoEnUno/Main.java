package todoEnUno;

import java.io.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		RandomAccessFile fileRand = new RandomAccessFile(new File("modulosdam.dat"),"rw");
		
		String modulos[] = {"Programación",
				   "Bases de datos",
				   "Entornos de desarrollo",
				   "Lenguaje de marcas",
				   "Sistemas Informáticos",
				   "Acceso a datos",
				   "Desarrollo de interfaces",
				   "Programación de servicios y procesos",
				   "Sistemas de gestión empresarial", 
				   "Programación multimedia y dispositivos móviles"};
		   int horas[] = {270, 205, 90, 140, 205, 120,120,80,95,80}; 
		   String cursos[] ={"1º", "1º","1º","1º","1º","2º","2º","2º","2º","2º"};
		   
		   
		   
		
	}
	
}
