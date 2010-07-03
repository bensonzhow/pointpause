package fr.afcepf.ai77.g1.persistence.entity;
import java.io.Serializable;
public class ModelAutomate implements Serializable{
	private int id, codeType, nbEmplacement, capaciteParEmplacement, hauteur, largeur, profondeur, prix;
	private String nom, description;
	private byte[] photo;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
