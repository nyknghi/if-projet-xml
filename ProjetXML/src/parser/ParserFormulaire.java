package parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import pojo.*;

public class ParserFormulaire extends DefaultHandler{
	private String typeAction="";
	private Activite activite;
	private Utilisateur utilisateur;
	private Coordonnee coord;
	private Adresse adr;
	private Service service = Service.getInstance();
	private Participation participation;
	private Formulaire formulaire;
	private String parent="", courant="";
	
	public void startDocument (){}
	public void endDocument (){}
	
	public void startElement (String url, String lName, String qName, Attributes att){
		formulaire = new Formulaire();
		if (qName.equals("action")){
			typeAction = att.getValue(0);
			participation = new Participation();
		}
		if (qName.equals("activite")){
			activite = new Activite();
			activite.setId(Integer.parseInt(att.getValue(0)));
			activite.setDebut(att.getValue(1));
			activite.setFin(att.getValue(2));
			activite.setType(att.getValue(3));
			parent = qName;
			if (participation != null){
				participation.setActivite(activite);
			}
		}
		if (qName.equals("utilisateur")){
			utilisateur = new Utilisateur();
			utilisateur.setAge(Integer.parseInt(att.getValue(0)));
			utilisateur.setGenre(att.getValue(1));
			utilisateur.setId(Integer.parseInt(att.getValue(2)));
			parent = qName;
			if (participation != null){
				participation.setUtilisateur(utilisateur);
			}
		}
		if (qName.equals("coordonnee")){ 
			coord = new Coordonnee();
			utilisateur.setCoordonnee(coord);
		}
		if (qName.equals("adresse")){ 
			adr = new Adresse();
//			parent = qName;
			utilisateur.getCoordonnee().setAdresse(adr);
		}		
		courant = qName;		
		formulaire = new Formulaire(utilisateur, typeAction, activite);
		service.addFormulaire(formulaire);
		service.addParticipation(participation);
	}
	
	public void endElement (String uri, String name, String qName){}
	
	public void ignorableWhitespace(char[] ch, int start, int end){
		try {
			super.ignorableWhitespace(ch, start, end);
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
	public void characters(char[] ch, int start, int end){
		String s = new String(ch, start, end);
		
		if (parent.equals("activite") && courant.equals("ville")){ activite.setVille(s); }
		if (parent.equals("activite") && courant.equals("nom")){
			activite.setNom(s);
		}
		if (courant.equals("commentaire")){	
			activite.setCommentaire(s);
			participation.setCommentaire(s);
		}
		if (courant.equals("note")){
			activite.setNote(Integer.parseInt(s));
			participation.setNote(Integer.parseInt(s));
		}
		
		if (parent.equals("utilisateur") && courant.equals("nom")){
			utilisateur.setNom(s);
		}
		if (courant.equals("numero")){ adr.setNumero(s); }
		if (courant.equals("rue")) { adr.setRue(s); }
		if (courant.equals("avenue")) { adr.setAvenue(s); }
		if (courant.equals("rue")) { adr.setRue(s); }
		if (courant.equals("code")) { adr.setCode(s); }
		if (parent.equals("utilisateur") && courant.equals("ville")){ adr.setVille(s); }
		if (courant.equals("mail")) { coord.setEmail(s); }
		if (courant.equals("telephone")) { coord.addTelephone(s); }
		if (courant.equals("hobby")) { utilisateur.setHobby(s); }
	}

	public void afficher(){
		System.out.println(formulaire);
		System.out.println(participation);
	}
	
	public String getTypeAction() {
		return typeAction;
	}
	public void setTypeAction(String typeAction) {
		this.typeAction = typeAction;
	}
	public Participation getParticipation() {
		return participation;
	}
	public void setParticipation(Participation participation) {
		this.participation = participation;
	}
}
