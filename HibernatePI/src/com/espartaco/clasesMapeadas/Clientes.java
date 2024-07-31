package com.espartaco.clasesMapeadas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Clientes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="direccion")
	private String direccion;
	
	/**
	 * oneToMeny mappedBy="cliente" indica que la entidad Pedido tiene un atributo llamado cliente que gestiona la relación
	 */
	@OneToMany(mappedBy="cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Pedido> pedidos;
	
	/**
	 * el 'cliente' es el nombre del atributo en la clase opuesta que gestiona la relación.
	 * cascade = CascadeType.ALL permite el borrado recurrente a las tablas relaccionadas, 
	 * si se elimina se puede borrar los detalles sin eliminar el cliente.
	 */
	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Detalles_cliente detalles;
	
	public Clientes(String nombre, String apellidos, String direccion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}

	public Clientes() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	

	public Detalles_cliente getDetalles() {
		return detalles;
	}

	public void setDetalles(Detalles_cliente detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", detalles=" + detalles + "]";
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	
/**
 * Establece relaccion bidireccional, asegura la integridad de los datos,
 * facilitar el acceso a los datos
 * @param pedido
 */
	public void agregaPedido(Pedido pedido) {
		
		if(pedidos==null) {
			
			pedidos= new ArrayList();
			
		}
			
			pedidos.add(pedido);
			
			pedido.setCliente(this);//agrega al pedido el cliente actual
			
	}

	
	
}
