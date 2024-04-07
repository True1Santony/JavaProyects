package matriculaCiclos;

public class Cualificacion {
	private String codigo;
	private String cualifica;
	private String completa;
	private Ciclo ciclo;
	public String getCompleta() {
		return completa;
	}
	public void setCompleta(String completa) {
		this.completa = completa;
	}
	public Cualificacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cualificacion(String codigo, String cualifica, String completa) {
		super();
		this.codigo = codigo;
		this.cualifica = cualifica;
		this.completa=completa;
	}
	@Override
	public String toString() {
		return "Cualificacion [codigo=" + codigo + ", cualifica=" + cualifica +" ,"+completa + "]";
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCualifica() {
		return cualifica;
	}
	public void setCualifica(String cualifica) {
		this.cualifica = cualifica;
	}

}
