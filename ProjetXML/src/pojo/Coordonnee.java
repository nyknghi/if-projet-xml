package pojo;

import java.util.ArrayList;
import java.util.List;

public class Coordonnee {
	private Adresse adresse;
	private String email;
	private List<String> telephone = new ArrayList<String>();
	
	public Coordonnee(){}
	
	public Coordonnee(Adresse adresse, String email, List<String> telephone) {
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getTelephone() {
		return telephone;
	}
	public void setTelephone(List<String> telephone) {
		this.telephone = telephone;
	}
	
	public void addTelephone(String tel){
		this.telephone.add(tel);
	}

	@Override
	public String toString() {
		return "Coordonnee [adresse=" + adresse + ", email=" + email
				+ ", telephone=" + telephone + "]";
	}
	
}
