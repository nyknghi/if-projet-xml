package pojo;

public class Participation {
	private Utilisateur utilisateur;
	private Activite activite;
	private String commentaire;
	private int note;

	public Participation(){}

	public Participation(Utilisateur utilisateur, Activite activite, String commentaire, int note) {		
		this.utilisateur = utilisateur;
		this.activite = activite;
		this.commentaire = commentaire;
		this.note = note;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Participation [utilisateur=" + utilisateur + ", \n activite="
				+ activite + "]";
	}		
}

