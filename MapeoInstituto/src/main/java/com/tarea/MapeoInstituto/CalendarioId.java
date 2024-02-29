package com.tarea.MapeoInstituto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Embeddable
public class CalendarioId implements Serializable {
	
	@Column(name = "Actividad")
    private Integer actividadId;

    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "Hora")
    private String hora;

    @Column(name = "Lugar")
    private String lugar;
	

	public CalendarioId(Integer actividad, Date fecha, String hora, String lugar) {
		super();
		this.actividadId = actividad;
		this.fecha = fecha;
		this.hora = hora;
		this.lugar = lugar;
	}
	
	public CalendarioId() {
		
	}
	
	
	public Integer getActividad() {
		return actividadId;
	}
	public void setActividad(Integer actividad) {
		this.actividadId = actividad;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	@Override
	public String toString() {
		return "CelendarioId [Actividad=" + actividadId + ", Fecha=" + fecha + ", Hora=" + hora + ", Lugar=" + lugar
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(actividadId, fecha, hora, lugar);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CalendarioId)) {
			return false;
		}
		CalendarioId other = (CalendarioId) obj;
		return Objects.equals(actividadId, other.actividadId) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(hora, other.hora) && Objects.equals(lugar, other.lugar);
	}
	
}
