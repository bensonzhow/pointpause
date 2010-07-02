package fr.afcepf.ai77.g1.persistence.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Incident {
	
	private Integer numero;
	private Client client;
	private Boolean flag;
	private Date dateDeclarationIncident;
	private Date dateConstatIncident;
	private Installation numeroDeploiement;
	private TypePb typePb; 
	private Set<StatutIncident> listeStatutsIncidents = new HashSet<StatutIncident>(); 
	
	
	
	public Set<StatutIncident> getListeStatutsIncidents() {
		return listeStatutsIncidents;
	}
	public void setListeStatutsIncidents(Set<StatutIncident> listeStatutsIncidents) {
		this.listeStatutsIncidents = listeStatutsIncidents;
	}
	public TypePb getTypePb() {
		return typePb;
	}
	public void setTypePb(TypePb typePb) {
		this.typePb = typePb;
	}
	public Installation getNumeroDeploiement() {
		return numeroDeploiement;
	}
	public void setNumeroDeploiement(Installation numeroDeploiement) {
		this.numeroDeploiement = numeroDeploiement;
	}
	public Date getDateConstatIncident() {
		return dateConstatIncident;
	}
	public void setDateConstatIncident(Date dateConstatIncident) {
		this.dateConstatIncident = dateConstatIncident;
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
		return "Incident [client=" + client + ", dateConstatIncident="
				+ dateConstatIncident + ", dateDeclarationIncident="
				+ dateDeclarationIncident + ", flag=" + flag + ", numero="
				+ numero + ", numeroDeploiement=" + numeroDeploiement
				+ ", typePb=" + typePb + "]";
	}
	
	public Incident(){
	
	}
	
	public Incident(Client client, Boolean flag, Date dateDeclarationIncident,
			Date dateConstatIncident, Installation numeroDeploiement) {
		super();
		this.client = client;
		this.flag = flag;
		this.dateDeclarationIncident = dateDeclarationIncident;
		this.dateConstatIncident = dateConstatIncident;
		this.numeroDeploiement = numeroDeploiement;
	}
	
	
	
	
	
}
