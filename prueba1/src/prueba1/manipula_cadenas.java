package prueba1;

public class manipula_cadenas {
	public static void main(String[] args) {
		
		
		String nombre="Espartaco";
		
		System.out.println("Mi nombre es " + nombre);
		
		System.out.println("Mi nombre tiene " + nombre.length() + " letras.");
		
		
		System.out.println("La quinta letra de " + nombre + " es la " + nombre.charAt(4));
		
		int ultima_letra;
				
		ultima_letra=nombre.length();
		
		System.out.println(ultima_letra);
		
		System.out.println("La ultima letra de mi nombre es: " + nombre.charAt(ultima_letra-1));
	}

}
