package fr.afcepf.ai77.g1.metiers.dto;

import java.io.Serializable;
import java.util.Date;

public class StatutIncidentDTO implements Serializable{
	private Integer numero;
	private String statut;
	private InterventionDTO intervention;
	private Date dateNouveauStatut;
	private String commentaire;
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public InterventionDTO getIntervention() {
		return intervention;
	}
	public void setIntervention(InterventionDTO intervention) {
		this.intervention = intervention;
	}
	public Date getDateNouveauStatut() {
		return dateNouveauStatut;
	}
	public void setDateNouveauStatut(Date dateNouveauStatut) {
		this.dateNouveauStatut = dateNouveauStatut;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	
	
	

}
