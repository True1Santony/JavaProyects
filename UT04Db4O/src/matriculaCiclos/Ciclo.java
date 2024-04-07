package matriculaCiclos;

import java.util.ArrayList;
public class Ciclo {
	private String codigo;
	private String nombre;
	private ArrayList<Cualificacion> cualificaciones;
	private String nivel;
	private Integer horas;
	private ArrayList<Modulo> modulos;
	public ArrayList<Modulo> getModulos() {
		return modulos;
	}
	public void setModulos(ArrayList<Modulo> modulos) {
		this.modulos = modulos;
	}
	public Ciclo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ciclo(String codigo, String nombre, ArrayList<Cualificacion> cualificaciones, String nivel, Integer horas) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cualificaciones = cualificaciones;
		this.nivel = nivel;
		this.horas = horas;
	}
	@Override
	public String toString() {
		return "Ciclo [codigo=" + codigo + ", nombre=" + nombre + ", cualificaciones=" + cualificaciones + ", nivel="
				+ nivel + ", horas=" + horas + "]";
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Cualificacion> getCualificaciones() {
		return cualificaciones;
	}
	public void setCualificaciones(ArrayList<Cualificacion> cualificaciones) {
		this.cualificaciones = cualificaciones;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
       
}
