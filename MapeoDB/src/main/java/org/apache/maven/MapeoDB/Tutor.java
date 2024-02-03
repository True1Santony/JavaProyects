package org.apache.maven.MapeoDB;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TUTORES")
public class Tutor{

	@Id
    @Column(name = "NOMBTUTOR")
    private String nomTutor;

    @Id
    @ManyToOne
    @JoinColumn(name = "NCONVENIO", referencedColumnName = "NCONVENIO")
    private Convenio convenio;

    @Column(name = "TEL")
    private int tel;

    @Column(name = "TMOVIL")
    private int tMovil;

	public String getNomTutor() {
		return nomTutor;
	}

	public void setNomTutor(String nomTutor) {
		this.nomTutor = nomTutor;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int gettMovil() {
		return tMovil;
	}

	public void settMovil(int tMovil) {
		this.tMovil = tMovil;
	}
}
