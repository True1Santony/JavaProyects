package org.apache.maven.MapeoDB;


import java.sql.Date;

import jakarta.persistence.Column;
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

	    @Id
	    @ManyToOne
	    @JoinColumn(name = "NCONVENIO", referencedColumnName = "NCONVENIO")
	    private Convenio convenio;

	    @Id
	    @ManyToOne
	    @JoinColumns({
	            @JoinColumn(name = "NPROGRAMA", referencedColumnName = "NPROGRAMA"),
	            @JoinColumn(name = "NCONVENIO", referencedColumnName = "NCONVENIO")
	    })
	    private ProgramaFormativo programaFormativo;

	    @Id
	    @ManyToOne
	    @JoinColumn(name = "DNI", referencedColumnName = "DNI")
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
}
