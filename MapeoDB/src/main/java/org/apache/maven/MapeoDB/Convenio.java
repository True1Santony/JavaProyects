package org.apache.maven.MapeoDB;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CONVENIOS")

public class Convenio {

	@Id
    @Column(name = "NCONVENIO")
    private int nConvenio;

    @Column(name = "EMPRESA", unique = true)
    private String empresa;

    @Column(name = "CIF", unique = true)
    private String cif;

    @Column(name = "REPRESENTANTE", nullable = false)
    private String representante;

    @Column(name = "NIF", nullable = false)
    private String nif;

    @Column(name = "DIRECCION", nullable = false)
    private String direccion;

    @Column(name = "POBLACION", nullable = false)
    private String poblacion;

    @Column(name = "PROVINCIA", nullable = false)
    private String provincia;

    @Column(name = "CP", nullable = false)
    private int cp;

    @Column(name = "TELEMP")
    private int telEmp;

    @Column(name = "CONTACTO")
    private String contacto;

    @Column(name = "TELCON")
    private int telCon;

    @Column(name = "TMOVIL")
    private Integer tMovil;//para aceptar null

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DISTANCIA")
    private int distancia;
    
    
    
		public int getnConvenio() {
			return nConvenio;
		}

		public void setnConvenio(int nConvenio) {
			this.nConvenio = nConvenio;
		}

		public String getEmpresa() {
			return empresa;
		}

		public void setEmpresa(String empresa) {
			this.empresa = empresa;
		}

		public String getCif() {
			return cif;
		}

		public void setCif(String cif) {
			this.cif = cif;
		}

		public String getRepresentante() {
			return representante;
		}

		public void setRepresentante(String representante) {
			this.representante = representante;
		}

		public String getNif() {
			return nif;
		}

		public void setNif(String nif) {
			this.nif = nif;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getPoblacion() {
			return poblacion;
		}

		public void setPoblacion(String poblacion) {
			this.poblacion = poblacion;
		}

		public String getProvincia() {
			return provincia;
		}

		public void setProvincia(String provincia) {
			this.provincia = provincia;
		}

		public int getCp() {
			return cp;
		}

		public void setCp(int cp) {
			this.cp = cp;
		}

		public int getTelEmp() {
			return telEmp;
		}

		public void setTelEmp(int telEmp) {
			this.telEmp = telEmp;
		}

		public String getContacto() {
			return contacto;
		}

		public void setContacto(String contacto) {
			this.contacto = contacto;
		}

		public int getTelCon() {
			return telCon;
		}

		public void setTelCon(int telCon) {
			this.telCon = telCon;
		}

		public Integer gettMovil() {
			return tMovil;
		}

		public void settMovil(Integer tMovil) {
			this.tMovil = tMovil;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getDistancia() {
			return distancia;
		}

		public void setDistancia(int distancia) {
			this.distancia = distancia;
		}

		@Override
		public String toString() {
			return "Convenio [nConvenio=" + nConvenio + ", empresa=" + empresa + ", cif=" + cif + ", representante="
					+ representante + ", nif=" + nif + ", direccion=" + direccion + ", poblacion=" + poblacion
					+ ", provincia=" + provincia + ", cp=" + cp + ", telEmp=" + telEmp + ", contacto=" + contacto
					+ ", telCon=" + telCon + ", tMovil=" + tMovil + ", email=" + email + ", distancia=" + distancia
					+ "]\n";
		}
	
}
