package fr.afcepf.ai77.g1.persistence.entity;

public class TypeStatutIncident {
	private Integer numeroType;
	private String libelle;
	private Integer couleur;
	private String libelleIntervention;
	public Integer getNumeroType() {
		return numeroType;
	}
	public void setNumeroType(Integer numeroType) {
		this.numeroType = numeroType;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Integer getCouleur() {
		return couleur;
	}
	public void setCouleur(Integer couleur) {
		this.couleur = couleur;
	}
	public String getLibelleIntervention() {
		return libelleIntervention;
	}
	public void setLibelleIntervention(String libelleIntervention) {
		this.libelleIntervention = libelleIntervention;
	}
	
	
}
