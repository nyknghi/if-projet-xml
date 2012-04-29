package pojo;

public class Formulaire {
	private Utilisateur utilisateur;
	private String typeAction;
	private Activite activite;
	
	public Formulaire(){}
	
	public Formulaire(Utilisateur utilisateur, String typeAction, Activite activite) {
		this.utilisateur = utilisateur;
		this.typeAction = typeAction;
		this.activite = activite;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getTypeAction() {
		return typeAction;
	}

	public void setTypeAction(String typeAction) {
		this.typeAction = typeAction;
	}

	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	@Override
	public String toString() {
		return "Formulaire [utilisateur=" + utilisateur + ", typeAction="
				+ typeAction + ", activite=" + activite + "]";
	}
}
