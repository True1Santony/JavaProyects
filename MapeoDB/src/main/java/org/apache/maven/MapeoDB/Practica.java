package org.apache.maven.MapeoDB;


import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "PRACTICAS")
public class Practica {
	
	  
	 @EmbeddedId
	    private PracticaId id;
	
	
		
	    @Column(name = "NCONVENIO")
	    private int nConvenio;
	
	    
	    @Column(name = "NPROGRAMA")
	    private int nPrograma;
	
	    
	    @Column(name = "DNI")
	    private int dni;

	    
	    @ManyToOne
	    @JoinColumn(name = "NCONVENIO", referencedColumnName = "NCONVENIO", insertable = false, updatable = false)
	    private Convenio convenio;

	    
	    @ManyToOne
	    @JoinColumns({
	            @JoinColumn(name = "NPROGRAMA", referencedColumnName = "NPROGRAMA", insertable = false, updatable = false),
	            @JoinColumn(name = "NCONVENIO", referencedColumnName = "NCONVENIO", insertable = false, updatable = false)
	    })
	    private ProgramaFormativo programaFormativo;

	    
	    @ManyToOne
	    @JoinColumn(name = "DNI", referencedColumnName = "DNI", insertable = false, updatable = false)
	    private Alumno alumno;

	    @Column(name = "FECINI")
	    @Temporal(TemporalType.DATE)
	    private Date fecIni;

	    @Column(name = "FECFIN")
	    @Temporal(TemporalType.DATE)
	    private Date fecFin;

	    @Column(name = "CENTRO_TRABAJO")
	    private String centroTrabajo;

	    @Column(name = "HORARIO")
	    private String horario;

	    @Column(name = "CURSO")
	    private String curso;

	    @Column(name = "NTUTOR")
	    private String nTutor;

	    @Column(name = "VALORACION")
	    private String valoracion;

		

		public Convenio getConvenio() {
			return convenio;
		}

		public void setConvenio(Convenio convenio) {
			this.convenio = convenio;
		}

		public ProgramaFormativo getProgramaFormativo() {
			return programaFormativo;
		}

		public void setProgramaFormativo(ProgramaFormativo programaFormativo) {
			this.programaFormativo = programaFormativo;
		}

		public Alumno getAlumno() {
			return alumno;
		}

		public void setAlumno(Alumno alumno) {
			this.alumno = alumno;
		}

		public Date getFecIni() {
			return fecIni;
		}

		public void setFecIni(Date fecIni) {
			this.fecIni = fecIni;
		}

		public Date getFecFin() {
			return fecFin;
		}

		public void setFecFin(Date fecFin) {
			this.fecFin = fecFin;
		}

		public String getCentroTrabajo() {
			return centroTrabajo;
		}

		public void setCentroTrabajo(String centroTrabajo) {
			this.centroTrabajo = centroTrabajo;
		}

		public String getHorario() {
			return horario;
		}

		public void setHorario(String horario) {
			this.horario = horario;
		}

		public String getCurso() {
			return curso;
		}

		public void setCurso(String curso) {
			this.curso = curso;
		}

		public String getnTutor() {
			return nTutor;
		}

		public void setnTutor(String nTutor) {
			this.nTutor = nTutor;
		}

		public String getValoracion() {
			return valoracion;
		}

		public void setValoracion(String valoracion) {
			this.valoracion = valoracion;
		}

		@Override
		public String toString() {
			return "Practica [nConvenio=" + nConvenio + ", nPrograma=" + nPrograma + ", dni=" + dni + ", fecIni="
					+ fecIni + ", fecFin=" + fecFin + ", centroTrabajo=" + centroTrabajo + ", horario=" + horario
					+ ", curso=" + curso + ", nTutor=" + nTutor + ", valoracion=" + valoracion + "]"+"["+convenio+"]"+"["+alumno+"]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(dni, nConvenio, nPrograma);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Practica other = (Practica) obj;
			return dni == other.dni && nConvenio == other.nConvenio && nPrograma == other.nPrograma;
		}

		public int getnConvenio() {
			return nConvenio;
		}

		public void setnConvenio(int nConvenio) {
			this.nConvenio = nConvenio;
		}

		public int getnPrograma() {
			return nPrograma;
		}

		public void setnPrograma(int nPrograma) {
			this.nPrograma = nPrograma;
		}

		public int getDni() {
			return dni;
		}

		public void setDni(int dni) {
			this.dni = dni;
		}
}
