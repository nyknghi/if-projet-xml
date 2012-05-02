package pojo;

public class Adresse {
	private String numero;
	private String rue = "";
	private String avenue = "";
	private String code;
	private String ville;
	
	public Adresse(){}
	
	public Adresse(String numero, String rue, String avenue, String code, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.avenue = avenue;
		this.code = code;
		this.ville = ville;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getAvenue() {
		return avenue;
	}
	public void setAvenue(String avenue) {
		this.avenue = avenue;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", rue=" + rue + ", avenue="
				+ avenue + ", code=" + code + ", ville=" + ville
				+ "]";
	}
}
