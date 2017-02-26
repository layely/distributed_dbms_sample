package servlet;


import java.util.ArrayList;
import java.util.List;

import metier.Logement;

public class LogementModel {
	private List<Logement> logements=new ArrayList<Logement>();
	private String motCle="";
	private Logement logement=new Logement();
	String errors="";
	String mode="ajout";
	public List<Logement> getLogements() {
		return logements;
	}

	public void setLogements(List<Logement> logements) {
		this.logements = logements;
	}

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public Logement getLogement() {
		return logement;
	}

	public void setLogement(Logement logement) {
		this.logement = logement;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
}
