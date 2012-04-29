package pojo;

import java.util.ArrayList;
import java.util.List;

public class Activite {
	private String ville;
	private String nom;
	private List<String> commentaire = new ArrayList<String>();
	private int note;
	private String debut;
	private String fin;
	private String type;
	
	public Activite(){}
	
	public Activite(String ville, String nom, List<String> commentaire,
			int note, String debut, String fin, String type) {
		this.ville = ville;
		this.nom = nom;
		this.commentaire = commentaire;
		this.note = note;
		this.debut = debut;
		this.fin = fin;
		this.type = type;
	}

	public void addNote(int n){
		this.note = (note+n)/2;
	}
	
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void addCommentaire(String c){
		this.commentaire.add(c);
	}
	
	public List<String> getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(List<String> commentaire) {
		this.commentaire = commentaire;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getDebut() {
		return debut;
	}

	public void setDebut(String debut) {
		this.debut = debut;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Activite [ville=" + ville + ", nom=" + nom + ", note=" + note
				+ ", debut=" + debut + ", fin=" + fin + ", type=" + type + "]";
	}
}
