package fr.afcepf.ai77.g1.persistence.entity;

import java.util.Date;

public class StatutIncident {
	
	
	private Integer numero=null;
	private Intervention intervention;
	//private Type_Statut_Incident typeStatutIncident;
	private Incident incident;
	private Date dateChangementStatut;
	private String commentaire;
	
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Intervention getIntervention() {
		return intervention;
	}
	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}
	public Incident getIncident() {
		return incident;
	}
	public void setIncident(Incident incident) {
		this.incident = incident;
	}
	public Date getDateChangementStatut() {
		return dateChangementStatut;
	}
	public void setDateChangementStatut(Date dateChangementStatut) {
		this.dateChangementStatut = dateChangementStatut;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	
	@Override
	public String toString() {
		return "StatutIncident [numero=" + numero + ", intervention="
				+ intervention + ", incident=" + incident
				+ ", dateChangementStatut=" + dateChangementStatut
				+ ", commentaire=" + commentaire + "]";
	}
	
	
	public StatutIncident( Intervention intervention,
			Incident incident, Date dateChangementStatut, String commentaire) {
		super();
		this.intervention = intervention;
		this.incident = incident;
		this.dateChangementStatut = dateChangementStatut;
		this.commentaire = commentaire;
	}

	public StatutIncident(){
	
	}
	
}
