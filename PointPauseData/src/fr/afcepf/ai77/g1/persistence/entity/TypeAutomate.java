package fr.afcepf.ai77.g1.persistence.entity;
import java.io.Serializable;
public class TypeAutomate implements Serializable{
	private int id;
	private String nom;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	

}
