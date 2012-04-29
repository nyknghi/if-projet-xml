package pojo;

import java.util.ArrayList;
import java.util.List;

public class Service {
	private List<Participation> participations = new ArrayList<Participation>();
	private List<Formulaire> formulaires = new ArrayList<Formulaire>();
	private static Service service;
	
	private Service(){}
	
	public static Service getInstance(){
		if (service == null){
			service = new Service();
		}
		return service;
	}

	public void addParticipation(Participation p){
		this.participations.add(p);
	}
	
	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public void addFormulaire(Formulaire f){
		this.formulaires.add(f);
	}
	
	public List<Formulaire> getFormulaires() {
		return formulaires;
	}

	public void setFormulaires(List<Formulaire> formulaires) {
		this.formulaires = formulaires;
	}	
}
