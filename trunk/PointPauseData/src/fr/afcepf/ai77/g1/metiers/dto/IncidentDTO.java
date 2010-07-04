package fr.afcepf.ai77.g1.metiers.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import fr.afcepf.ai77.g1.persistence.entity.Client;

public class IncidentDTO implements Serializable {
	
	private Integer numero;
	private Integer numClient;
	private Boolean flag;
	private Date dateDeclarationIncident;
	private Date dateConstatIncident;
	private Integer numInstallation;
	private String commentaire;
	private Integer numContrat;
	private Integer numTypePb;
	
	private List<StatutIncidentDTO> historique = new Vector<StatutIncidentDTO>();


	
	public List<StatutIncidentDTO> getHistorique() {
		return historique;
	}
	public void setHistorique(List<StatutIncidentDTO> historique) {
		this.historique = historique;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getNumClient() {
		return numClient;
	}
	public void setNumClient(Integer numClient) {
		this.numClient = numClient;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public Date getDateDeclarationIncident() {
		return dateDeclarationIncident;
	}
	public void setDateDeclarationIncident(Date dateDeclarationIncident) {
		this.dateDeclarationIncident = dateDeclarationIncident;
	}
	public Date getDateConstatIncident() {
		return dateConstatIncident;
	}
	public void setDateConstatIncident(Date dateConstatIncident) {
		this.dateConstatIncident = dateConstatIncident;
	}
	public Integer getNumInstallation() {
		return numInstallation;
	}
	public void setNumInstallation(Integer numInstallation) {
		this.numInstallation = numInstallation;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Integer getNumContrat() {
		return numContrat;
	}
	public void setNumContrat(Integer numContrat) {
		this.numContrat = numContrat;
	}
	public Integer getNumTypePb() {
		return numTypePb;
	}
	public void setNumTypePb(Integer numTypeProb) {
		this.numTypePb = numTypeProb;
	}
	
	@Override
	public String toString() {
		return "IncidentDTO [commentaire=" + commentaire
				+ ", dateConstatIncident=" + dateConstatIncident
				+ ", dateDeclarationIncident=" + dateDeclarationIncident
				+ ", flag=" + flag + ", numClient=" + numClient
				+ ", numContrat=" + numContrat + ", numInstallation="
				+ numInstallation + ", numTypeProb=" + numTypePb
				+ ", numero=" + numero + "]";
	}
	
}
