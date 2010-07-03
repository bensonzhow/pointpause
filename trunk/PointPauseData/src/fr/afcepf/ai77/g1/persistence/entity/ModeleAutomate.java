package fr.afcepf.ai77.g1.persistence.entity;
import java.io.Serializable;
public class ModeleAutomate implements Serializable{
	private TypeAutomate type;
	private Integer id, prix;
	private float nbEmplacement, capaciteParEmplacement, hauteur, largeur, profondeur; 
	private String nom, description;
	private byte[] photo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public TypeAutomate getType() {
		return type;
	}
	public void setType(TypeAutomate type) {
		this.type = type;
	}
	public float getNbEmplacement() {
		return nbEmplacement;
	}
	public void setNbEmplacement(float nbEmplacement) {
		this.nbEmplacement = nbEmplacement;
	}
	public float getCapaciteParEmplacement() {
		return capaciteParEmplacement;
	}
	public void setCapaciteParEmplacement(float capaciteParEmplacement) {
		this.capaciteParEmplacement = capaciteParEmplacement;
	}
	public float getHauteur() {
		return hauteur;
	}
	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}
	public float getLargeur() {
		return largeur;
	}
	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}
	public float getProfondeur() {
		return profondeur;
	}
	public void setProfondeur(float profondeur) {
		this.profondeur = profondeur;
	}
	public void setProfondeur(Integer profondeur) {
		this.profondeur = profondeur;
	}
	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
		this.prix = prix;
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
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
}
