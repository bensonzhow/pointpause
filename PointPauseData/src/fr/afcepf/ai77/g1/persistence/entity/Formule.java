package fr.afcepf.ai77.g1.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.hibernate.type.BigDecimalType;

public class Formule implements Serializable{

	
	private Integer codeFormule; 
	private String commentaireFormule;
	private Double prix;
	private Client client;
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	private String libelleFormule;
	public Integer getCodeFormule() {
		return codeFormule;
	}
	public void setCodeFormule(Integer pCodeFormule) {
		codeFormule = pCodeFormule;
	}
	public String getCommentaireFormule() {
		return commentaireFormule;
	}
	public void setCommentaireFormule(String pCommentaireFormule) {
		commentaireFormule = pCommentaireFormule;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double pPrix) {
		prix = pPrix;
	}
	public String getLibelleFormule() {
		return libelleFormule;
	}
	public void setLibelleFormule(String pLibelleFormule) {
		libelleFormule = pLibelleFormule;
	}
}
