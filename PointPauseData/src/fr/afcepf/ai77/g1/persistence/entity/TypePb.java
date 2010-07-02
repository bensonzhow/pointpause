package fr.afcepf.ai77.g1.persistence.entity;

public class TypePb {

	private Integer numTypePb;
	private String libelle;
	
	public Integer getNumTypePb() {
		return numTypePb;
	}
	public void setNumTypePb(Integer numTypePb) {
		this.numTypePb = numTypePb;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@Override
	public String toString() {
		return "TypePb [libelle=" + libelle + ", numTypePb=" + numTypePb + "]";
	}
	
	public TypePb() {
		
	}
	public TypePb(Integer numTypePb, String libelle) {
		super();
		this.numTypePb = numTypePb;
		this.libelle = libelle;
	}
	
	
	
	
}
