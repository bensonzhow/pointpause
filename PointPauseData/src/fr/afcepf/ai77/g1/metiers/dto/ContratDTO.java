package fr.afcepf.ai77.g1.metiers.dto;

import java.util.Date;
import java.util.HashSet;

import java.util.Set;

import fr.afcepf.ai77.g1.persistence.entity.Bouquet;

public class ContratDTO {
	private Integer numero;
	private Integer numClient;
	//private Contrat contrat;
	private Date dateDebut;
	private Date dateFin;
	private Boolean garantie;
	private Integer freqApprovisionnement;
	private Date dateSignature;
	private int duree;
	private String commentaire;
	private Boolean flag;
	private Set<Bouquet> listeBouquets = new HashSet<Bouquet>();
	
	
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Boolean getGarantie() {
		return garantie;
	}
	public void setGarantie(Boolean garantie) {
		this.garantie = garantie;
	}
	public Integer getFreqApprovisionnement() {
		return freqApprovisionnement;
	}
	public void setFreqApprovisionnement(Integer freqApprovisionnement) {
		this.freqApprovisionnement = freqApprovisionnement;
	}
	public Date getDateSignature() {
		return dateSignature;
	}
	public void setDateSignature(Date dateSignature) {
		this.dateSignature = dateSignature;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public Set<Bouquet> getListeBouquets() {
		return listeBouquets;
	}
	public void setListeBouquets(Set<Bouquet> listeBouquets) {
		this.listeBouquets = listeBouquets;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public void setNumClient(Integer numClient) {
		this.numClient = numClient;
	}
	public Integer getNumClient() {
		return numClient;
	}

	
	
}


