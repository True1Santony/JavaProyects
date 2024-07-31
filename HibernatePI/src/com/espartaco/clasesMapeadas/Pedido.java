package com.espartaco.clasesMapeadas;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column
	private Date fecha;
	
	@Column
	private String formapago;
	
	/**
	 * joinColumn indica el campo de la tabla pedidos de la clave foranea que hara de ralaccion con la otra tabla
	 * 
	 */
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="clienteid")
	private Clientes cliente;

	public Pedido(Date fecha) {
		super();
		this.fecha = fecha;
	}

	public String getFormapago() {
		return formapago;
	}

	public void setFormapago(String formapago) {
		this.formapago = formapago;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + ", formapago=" + formapago + "]";
	}
	
	
	
}
