package modelo;

import java.time.LocalDate;
import java.util.Date;

public class Multa {
	transient LocalDate fnicio;
	transient LocalDate ffin;
	public LocalDate getFnicio() {
		return fnicio;
	}
	public void setFnicio(LocalDate fnicio) {
		this.fnicio = fnicio;
	}
	public LocalDate getFfin() {
		return ffin;
	}
	public void setFfin(LocalDate ffin) {
		this.ffin = ffin;
	}
	@Override
	public String toString() {
		return "Multa [fnicio=" + fnicio + ", ffin=" + ffin + "]";
	}
	

}
