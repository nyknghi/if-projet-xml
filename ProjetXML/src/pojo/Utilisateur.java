package pojo;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
	private String nom;
	private Coordonnee coordonnee;
	private List<String> hobby = new ArrayList<String>();
	private int age;
	private String genre;
	
	public Utilisateur(){}
	
	public Utilisateur(String nom, Coordonnee coordonnee, List<String> hobby, int age, String genre) {
		this.nom = nom;
		this.coordonnee = coordonnee;
		this.hobby = hobby;
		this.age = age;
		this.genre = genre;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Coordonnee getCoordonnee() {
		return coordonnee;
	}
	public void setCoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
	}
	
	public void addHobby(String h){
		this.hobby.add(h);
	}
	
	public List<String> getHobby() {
		return hobby;
	}
	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}
 
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", hobby=" + hobby + ", age=" + age
				+ ", genre=" + genre + "]";
	}
}
