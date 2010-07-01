package fr.afcepf.ai77.g1.persistence.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


//FIXME : ce truc n'est qu'un squelette de classe !

/*
* 
* 
* Stub : a finir !
* 
* 
*/

public class Contrat {
	private Integer numero;
	private Client client;
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	@Override
	public String toString() {
		return "Contrat [numero=" + numero + ", client=" + client + "]";
	}
	public Contrat(Integer numero, Client client, Date dateDebut, Date dateFin,
			Boolean garantie, Integer freqApprovisionnement,
			Date dateSignature, int duree, String commentaire, Boolean flag) {
		super();
		this.numero = numero;
		this.client = client;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.garantie = garantie;
		this.freqApprovisionnement = freqApprovisionnement;
		this.dateSignature = dateSignature;
		this.duree = duree;
		this.commentaire = commentaire;
		this.flag = flag;
	}
	
	public Contrat(){
		
	}
	
}














