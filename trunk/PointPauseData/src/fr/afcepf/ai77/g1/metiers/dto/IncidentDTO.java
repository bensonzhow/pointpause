package fr.afcepf.ai77.g1.metiers.dto;

import java.io.Serializable;
import java.util.Date;

import fr.afcepf.ai77.g1.persistence.entity.Client;

public class IncidentDTO implements Serializable {
	
	private Integer numero;
	private Client client;
	private Boolean flag;
	private Date dateDeclarationIncident;
	private Date dateConstatIncident;
	
	
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
	
	
	@Override
	public String toString() {
		return "IncidentDTO [client=" + client + ", dateConstatIncident="
				+ dateConstatIncident + ", dateDeclarationIncident="
				+ dateDeclarationIncident + ", flag=" + flag + ", numero="
				+ numero + "]";
	}
	
}
