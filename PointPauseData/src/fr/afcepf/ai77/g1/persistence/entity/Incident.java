package fr.afcepf.ai77.g1.persistence.entity;

import java.util.Date;

public class Incident {
	
	private Integer numero;
	private Client client;
	private Boolean flag;
	private Date dateDeclarationIncident;
	private Date dateConstatIncident;
	
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
				+ numero + "]";
	}
	public Incident(Integer numero, Client client, Boolean flag,
			Date dateDeclarationIncident, Date dateConstatIncident) {
		super();
		this.numero = numero;
		this.client = client;
		this.flag = flag;
		this.dateDeclarationIncident = dateDeclarationIncident;
		this.dateConstatIncident = dateConstatIncident;
	}
	
	
	public Incident(){
		
	}
	
}
