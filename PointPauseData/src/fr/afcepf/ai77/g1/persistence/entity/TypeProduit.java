package fr.afcepf.ai77.g1.persistence.entity;

import java.util.HashSet;
import java.util.Set;

public class TypeProduit {
	
	private Integer codeType;
	//private int codeModeConserv;
	private String libelle;
	private String commentaire;
	private Set<Produit> listeProduits = new HashSet<Produit>();
	
	
	@Override
	public String toString() {
		return "TypeProduit [codeType=" + codeType + ", libelle=" + libelle
				+ ", commentaire=" + commentaire + "]";
	}
	public Integer getCodeType() {
		return codeType;
	}
	public void setCodeType(Integer codeType) {
		this.codeType = codeType;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Set<Produit> getListeProduits() {
		return listeProduits;
	}
	public void setListeProduits(Set<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}
	
	public TypeProduit(Integer codeType, String libelle, String commentaire) {
		super();
		this.codeType = codeType;
		this.libelle = libelle;
		this.commentaire = commentaire;
	}
	
	public TypeProduit(){
		
	}
	
}
