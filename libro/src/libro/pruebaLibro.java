package libro;

public class pruebaLibro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		libro libro1=new libro();
		libro libro2=new libro("Manolito Gagotas", "Paco Reberte", 2);
		
		libro1.estableceAutor("Amalia Montero");
		libro1.estableceCodigo(1);
		libro1.estableceTitulo(" El fin del mundo");
		
		libro1.prestar(true);
		libro1.prestar(true);
		
		
		System.out.println(libro1.devuelveDatos());
	}

}
