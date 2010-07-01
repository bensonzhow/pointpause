package fr.afcepf.ai77.g1.persistence.entity;

public class Produit {
	private Integer numero=null;
	private TypeProduit typeProduit;
	private String libelle;
	private Double prix;
	
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public TypeProduit getTypeProduit() {
		return typeProduit;
	}
	public void setTypeProduit(TypeProduit typeProduit) {
		this.typeProduit = typeProduit;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Produit [numero=" + numero + ", typeProduit=" + typeProduit
				+ ", libelle=" + libelle + ", prix=" + prix + "]";
	}
	public Produit( TypeProduit typeProduit, String libelle,
			Double prix) {
		super();
		this.typeProduit = typeProduit;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	
	
	public Produit(){
		
	}
	
}
