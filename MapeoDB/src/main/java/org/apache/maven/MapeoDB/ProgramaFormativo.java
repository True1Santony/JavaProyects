package org.apache.maven.MapeoDB;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROG_FORMATIVOS")
public class ProgramaFormativo {

	@Id
    @ManyToOne
    @JoinColumn(name = "NCONVENIO", referencedColumnName = "NCONVENIO")
    private Convenio convenio;

    @Id
    @Column(name = "NPROGRAMA")
    private int nPrograma;

    @Column(name = "APRODUCTIVA", length = 1000)
    private String aProductiva;

    @Column(name = "AEVALUACION", length = 1000)
    private String aEvaluacion;

    @Column(name = "CTERMINAL", length = 1000)
    private String cTerminal;

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public int getnPrograma() {
		return nPrograma;
	}

	public void setnPrograma(int nPrograma) {
		this.nPrograma = nPrograma;
	}

	public String getaProductiva() {
		return aProductiva;
	}

	public void setaProductiva(String aProductiva) {
		this.aProductiva = aProductiva;
	}

	public String getaEvaluacion() {
		return aEvaluacion;
	}

	public void setaEvaluacion(String aEvaluacion) {
		this.aEvaluacion = aEvaluacion;
	}

	public String getcTerminal() {
		return cTerminal;
	}

	public void setcTerminal(String cTerminal) {
		this.cTerminal = cTerminal;
	}

	@Override
	public String toString() {
		return "ProgramaFormativo [convenio=" + convenio + ", nPrograma=" + nPrograma + ", aProductiva=" + aProductiva
				+ ", aEvaluacion=" + aEvaluacion + ", cTerminal=" + cTerminal + "]\n";
	}

		

	
	
}
