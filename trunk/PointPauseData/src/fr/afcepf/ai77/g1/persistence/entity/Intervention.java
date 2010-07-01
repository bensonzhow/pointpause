package fr.afcepf.ai77.g1.persistence.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Intervention {
	private Integer numero;
	private Employe employe;
	
	private Set<ProduitsIntervention> listeProduits = new HashSet<ProduitsIntervention>();
	
	private StatutIncident statutIncident;
	//private Urgence urgence;
	
	public StatutIncident getStatutIncident() {
		return statutIncident;
	}
	public void setStatutIncident(StatutIncident statutIncident) {
		this.statutIncident = statutIncident;
	}
	private Date dateDebutIntervention;
	private Date dateFinIntervention;
	private Boolean statut;
	private String commentaire;
	

	public Set<ProduitsIntervention> getListeProduits() {
		return listeProduits;
	}
	public void setListeProduits(Set<ProduitsIntervention> listeProduits) {
		this.listeProduits = listeProduits;
	}
	public Date getDateDebutIntervention() {
		return dateDebutIntervention;
	}
	public void setDateDebutIntervention(Date dateDebutIntervention) {
		this.dateDebutIntervention = dateDebutIntervention;
	}
	public Date getDateFinIntervention() {
		return dateFinIntervention;
	}
	public void setDateFinIntervention(Date dateFinIntervention) {
		this.dateFinIntervention = dateFinIntervention;
	}
	public Boolean getStatut() {
		return statut;
	}
	public void setStatut(Boolean statut) {
		this.statut = statut;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	@Override
	public String toString() {
		return "Intervention [numero=" + numero + ", employe=" + employe
				+ ", listeProduits=" + listeProduits
				+ ", dateDebutIntervention=" + dateDebutIntervention
				+ ", dateFinIntervention=" + dateFinIntervention + ", statut="
				+ statut + ", commentaire=" + commentaire + "]";
	}
	public Intervention(Integer numero, Employe employe,
			StatutIncident statutIncident, Date dateDebutIntervention,
			Date dateFinIntervention, Boolean statut, String commentaire) {
		super();
		this.numero = numero;
		this.employe = employe;
		this.statutIncident = statutIncident;
		this.dateDebutIntervention = dateDebutIntervention;
		this.dateFinIntervention = dateFinIntervention;
		this.statut = statut;
		this.commentaire = commentaire;
	}
	
	public Intervention(){
		
	}
	
}
