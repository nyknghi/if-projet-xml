package parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import pojo.Participation;

public class Traiter {
	Document utilisateurDoc, serviceDoc;
	private Participation participation;
	
	public Traiter(Participation p){
		participation = p;
	}
	
	public void inscrire() {
		Element e2 = utilisateurDoc.createElement("utilisateur");
		utilisateurDoc.getFirstChild().appendChild(e2);
		e2.setAttribute("id", Integer.toString(participation.getUtilisateur().getId()));
		e2.setAttribute("genre", this.participation.getUtilisateur().getGenre());
		e2.setAttribute("age", Integer.toString(this.participation.getUtilisateur().getAge()));
		ajouterFeuille(e2,"nom", this.participation.getUtilisateur().getNom());
		e2.appendChild(ajouterCoordonnee(e2));
		ajouterFeuille(e2,"hobby", this.participation.getUtilisateur().getHobby());	
	}
	
	public void desinscrire() {
		Node lutilisateurs = utilisateurDoc.getFirstChild();
		NodeList utilisateurs = lutilisateurs.getChildNodes();
		for (int i = 0; i < utilisateurs.getLength(); i++) {
			if (utilisateurs.item(i).getAttributes().item(2).getTextContent().equals(Integer.toString(participation.getUtilisateur().getId()))) {
				lutilisateurs.removeChild(utilisateurs.item(i));
			}
		}
	}
	
	public void commenter() {
		Node service = serviceDoc.getFirstChild();
		NodeList participations = service.getChildNodes();
		int i = 0;
		boolean isExistId = false;
		while (i < participations.getLength()) {
			System.out.println(participations.item(i).getFirstChild().getAttributes().item(0).getTextContent());
			if (participations.item(i).getChildNodes().item(0).getAttributes().item(0).getTextContent().equals(Integer.toString(participation.getUtilisateur().getId()))) {
				if (participations.item(i).getChildNodes().item(1).getAttributes().item(0).getTextContent().equals(Integer.toString(participation.getActivite().getId()))) {
					Element e2 = serviceDoc.createElement("commentaire");
					participations.item(i).getChildNodes().item(2).appendChild(e2);
					e2.setTextContent(participation.getActivite().getCommentaire());
					isExistId = true;
					break;
				}
			}
			i++;
		}
		if (isExistId == false) {
			Element e = serviceDoc.createElement("participation");
			service.appendChild(e);
			Element e2 = serviceDoc.createElement("utilisateur");
			e2.setAttribute("id", Integer.toString(participation.getUtilisateur().getId()));
			e.appendChild(e2);
			e2 = serviceDoc.createElement("activite");
			e2.setAttribute("id", Integer.toString(participation.getActivite().getId()));
			e.appendChild(e2);
			e2 = serviceDoc.createElement("commentaire");
			e.appendChild(e2);
			ajouterFeuille(e2,"commentaire", participation.getActivite().getCommentaire());
		}
	}
	
	public void noter() {
		Node service = serviceDoc.getFirstChild();
		NodeList participations = service.getChildNodes();
		int i = 0;
		boolean isExistId = false;
		while (i < participations.getLength()) {
			System.out.println(participations.item(i).getFirstChild().getAttributes().item(0).getTextContent());
			if (participations.item(i).getChildNodes().item(0).getAttributes().item(0).getTextContent().equals(Integer.toString(participation.getUtilisateur().getId()))) {
				if (participations.item(i).getChildNodes().item(1).getAttributes().item(0).getTextContent().equals(Integer.toString(participation.getActivite().getId()))) {
					Element e2 = serviceDoc.createElement("commentaire");
					participations.item(i).getChildNodes().item(3).setTextContent(Integer.toString(participation.getActivite().getNote()));
					isExistId = true;
					break;
				}
			}
			i++;
		}
		if (isExistId == false) {
			Element e = serviceDoc.createElement("participation");
			service.appendChild(e);
			Element e2 = serviceDoc.createElement("utilisateur");
			e2.setAttribute("id", Integer.toString(participation.getUtilisateur().getId()));
			e.appendChild(e2);
			e2 = serviceDoc.createElement("activite");
			e2.setAttribute("id", Integer.toString(participation.getActivite().getId()));
			e.appendChild(e2);
			e2 = serviceDoc.createElement("note");
			e.appendChild(e2);	
			ajouterFeuille(e2,"note", Integer.toString(participation.getActivite().getNote()));
		}
	}	

	public Element ajouterUtilisateur(Node node){
		Element e2 = utilisateurDoc.createElement("utilisateur");
		node.appendChild(e2);
		e2.setAttribute("id", Integer.toString(participation.getUtilisateur().getId()));
		e2.setAttribute("genre", this.participation.getUtilisateur().getGenre());
		e2.setAttribute("age", Integer.toString(this.participation.getUtilisateur().getAge()));
		ajouterFeuille(e2,"nom", this.participation.getUtilisateur().getNom());
		e2.appendChild(ajouterCoordonnee(e2));
		ajouterFeuille(e2,"hobby", this.participation.getUtilisateur().getHobby());		
		return e2;
	}

	public Element ajouterActivite(Element e){
		Element e2 = utilisateurDoc.createElement("activite");
		e.appendChild(e2);
		e2.setAttribute("debut", this.participation.getActivite().getDebut());
		e2.setAttribute("fin", this.participation.getActivite().getFin());
		e2.setAttribute("type", this.participation.getActivite().getType());
		ajouterFeuille(e2,"ville", this.participation.getActivite().getVille());
		ajouterFeuille(e2,"nom", this.participation.getActivite().getNom());
		ajouterFeuille(e2,"commentaire",this.participation.getActivite().getCommentaire());
		ajouterFeuille(e2,"note", Integer.toString(this.participation.getActivite().getNote()));		
		return e2;
	}

	public Element ajouterCoordonnee(Element e){
		Element e2 = utilisateurDoc.createElement("coordonne");
		e.appendChild(e2);
		e2.appendChild(ajouterAdresse(e2));
		return e2;
	}

	public Element ajouterAdresse(Element e){
		Element e2 = utilisateurDoc.createElement("adresse");
		e.appendChild(e2);
		ajouterFeuille(e2, "rue", this.participation.getUtilisateur().getCoordonnee().getAdresse().getAvenue());
		ajouterFeuille(e2, "code",this.participation.getUtilisateur().getCoordonnee().getAdresse().getCode());		
		ajouterFeuille(e2, "ville",this.participation.getUtilisateur().getCoordonnee().getAdresse().getVille());
		return e2;
	}

	private void ajouterFeuille(Element e, String nom, String nomE){
		Element e2 = e.getOwnerDocument().createElement(nom);
		e.appendChild(e2);
		e2.setTextContent(nomE);
	}
	
	public Participation getPariticipation() {
		return participation;
	}
	public void setPariticipation(Participation pariticipation) {
		this.participation = pariticipation;
	}

	public Document getUtilisateurDoc() {
		return utilisateurDoc;
	}

	public void setUtilisateurDoc(Document utilisateurDoc) {
		this.utilisateurDoc = utilisateurDoc;
	}

	public Document getServiceDoc() {
		return serviceDoc;
	}

	public void setServiceDoc(Document serviceDoc) {
		this.serviceDoc = serviceDoc;
	}
	
}
