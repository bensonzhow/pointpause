package fr.afcepf.ai77.g1.persistence.entity;

public class Incident {
	private Integer numero;
	private Client client;
	
	
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
		return "Incident [numero=" + numero + ", client=" + client + "]";
	}
	
	
	
}
