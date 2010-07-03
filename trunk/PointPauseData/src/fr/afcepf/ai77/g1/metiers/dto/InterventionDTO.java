package fr.afcepf.ai77.g1.metiers.dto;

import java.io.Serializable;
import java.util.Date;

public class InterventionDTO implements Serializable {
	private String nomEmploye;
	private String urgence;
	private Date debutIntervention;
	private Date finIntervention;
	private String commentaire;
	
	
	public String getNomEmploye() {
		return nomEmploye;
	}
	
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	
	public String getUrgence() {
		return urgence;
	}
	
	public void setUrgence(String urgence) {
		this.urgence = urgence;
	}
	
	public Date getDebutIntervention() {
		return debutIntervention;
	}
	
	public void setDebutIntervention(Date debutIntervention) {
		this.debutIntervention = debutIntervention;
	}
	public Date getFinIntervention() {
		return finIntervention;
	}
	
	public void setFinIntervention(Date finIntervention) {
		this.finIntervention = finIntervention;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	
}
