package pojo;

public class Participation {
	private Utilisateur utilisateur;
	private Activite activite;

	public Participation(){}

	public Participation(Utilisateur utilisateur, Activite activite) {		
		this.utilisateur = utilisateur;
		this.activite = activite;
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

	@Override
	public String toString() {
		return "Participation [utilisateur=" + utilisateur + ", activite="
				+ activite + "]";
	}		
}

