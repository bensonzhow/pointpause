package fr.afcepf.ai77.g1.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.hibernate.type.BigDecimalType;

public class Formule implements Serializable{

	
	private int codeFormule; 
	private String commentaireFormule;
	private Double prix;
	private String libelleFormule;
	public int getCodeFormule() {
		return codeFormule;
	}
	public void setCodeFormule(int pCodeFormule) {
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
