package pojo;

public class Utilisateur {
	private String nom;
	private int age;
	private String genre;
	private Coordonnee coordonnee;
	private String hobby;
	private int id;
	
	public Utilisateur(){}
	
	public Utilisateur(String nom, Coordonnee coordonnee, String hobby, int age, String genre) {
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
	
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", hobby=" + hobby + ", age=" + age
				+ ", genre=" + genre + "]\n" + this.getCoordonnee().toString();
	}
}
