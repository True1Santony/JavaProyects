package com.espartaco.clasesMapeadas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalles_cliente")
public class Detalles_cliente {

	
	public Detalles_cliente() {
		super();
	}

	public Detalles_cliente(String web, String telefono, String comentarios) {
		super();
		
		this.web = web;
		this.telefono = telefono;
		this.comentarios = comentarios;
		
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "web")
    private String web;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "comentarios")
    private String comentarios;

    //name el nombre de la columna en la tabla, se refiere al id de la tabla de clientes
    @OneToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id", nullable = false)
    private Clientes cliente;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

	@Override
	public String toString() {
		return "Detalles_cliente [id=" + id + ", web=" + web + ", telefono=" + telefono + ", comentarios=" + comentarios
				+ "]";
	}

 
}
