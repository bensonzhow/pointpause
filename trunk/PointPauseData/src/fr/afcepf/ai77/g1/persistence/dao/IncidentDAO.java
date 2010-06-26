package fr.afcepf.ai77.g1.persistence.dao;

public class IncidentDAO {
	private Integer numero;
	private ClientDAO client;
	
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public ClientDAO getClient() {
		return client;
	}
	public void setClient(ClientDAO client) {
		this.client = client;
	}
	
	
	@Override
	public String toString() {
		return "IncidentDAO [numero=" + numero + ", client=" + client + "]";
	}
	
	
	
}
