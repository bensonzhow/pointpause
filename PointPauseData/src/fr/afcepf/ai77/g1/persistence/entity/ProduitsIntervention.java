package fr.afcepf.ai77.g1.persistence.entity;

public class ProduitsIntervention {
	private Intervention intervention;
	private Produit produit;
	private Integer quantite;
	
	
	public Intervention getIntervention() {
		return intervention;
	}
	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	@Override
	public String toString() {
		return "ProduitsIntervention [intervention=" + intervention
				+ ", produit=" + produit + ", quantite=" + quantite + "]";
	}
	
	
	
}
