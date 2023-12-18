package libro;

public class libro {
	
	private String titulo;
	private String autor;
	private int codigo;
	private boolean prestado;
	
	public libro() {
		
	}
	
	public libro(String titulo,String autor, int codigo ) {
		
		this.titulo=titulo;
		this.autor=autor;
		this.codigo=codigo;
		prestado=false;
	}
	public boolean prestar(boolean prestar) {
		if(prestado==false) {
			prestado=true;//establece trestado en true(esta prestado)
			System.out.println("El libro"+titulo+" ha sido prestado");
			return true;       // devuelve true, se ha podido prestar
		}else {
			System.out.println("El libro"+titulo+" no se puede prestar otra vez.");
			return false;	  // devuelve false si ya esta prestado
		}
		

	}
	public boolean devolver() {
		if(prestado==true) {
			prestado=false;   //estableve prestado en false(es devuelto)
			System.out.println("El libro"+titulo+" ha sido devuelto.");
			return true;    //devuelve true, se ha podido devolver
		}else {
			System.out.println("El libro"+titulo+" ya ha sido devuelto.");
			return false;    //devuelve false si ya esta devuelto.
		}
	}
    public void estableceTitulo(String titulo) {
    	this.titulo=titulo;
    	
    }
    public void estableceAutor(String autor) {
    	this.autor=autor;
    }
    public void estableceCodigo(int codigo) {
    	this.codigo=codigo;
}
    public String devuelveDatos() {
    	
    	String a=prestado ? "si" : "no";
    	return "El titulo es:"+ titulo+"\nEl autor es: "+autor+"\nEl codigo es:"+codigo+"\nSe encuentra prestado:"+ a;
    }
}
