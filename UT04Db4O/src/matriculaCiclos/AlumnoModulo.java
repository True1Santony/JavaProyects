package matriculaCiclos;

public class AlumnoModulo {
private Modulo modulo;
private Alumno alumno;
private Integer ordinaria;
private Integer extraordinaria;
public Modulo getModulo() {
	return modulo;
}
public void setModulo(Modulo modulo) {
	this.modulo = modulo;
}
public AlumnoModulo(Modulo modulo, Alumno alumno) {
	super();
	this.modulo = modulo;
	this.alumno = alumno;
}
	

public AlumnoModulo(Modulo modulo, Alumno alumno, Integer ordinaria, Integer extraordinaria) {
	super();
	this.modulo = modulo;
	this.alumno = alumno;
	this.ordinaria = ordinaria;
	this.extraordinaria = extraordinaria;
	
}
public AlumnoModulo() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "AlumnoModulo [modulo=" + modulo + ", alumno=" + alumno + ", ordinaria=" + ordinaria + ", extraordinaria="
			+ extraordinaria + "]";
}
public Alumno getAlumno() {
	return alumno;
}
public void setAlumno(Alumno alumno) {
	this.alumno = alumno;
}
public Integer getOrdinaria() {
	return ordinaria;
}
public void setOrdinaria(Integer ordinaria) {
	this.ordinaria = ordinaria;
}
public Integer getExtraordinaria() {
	return extraordinaria;
}
public void setExtraordinaria(Integer extraordinaria) {
	this.extraordinaria = extraordinaria;
}
}
