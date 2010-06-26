package fr.afcepf.ai77.g1.persistence.dao;

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
public class EmployeDAO {
	
	private Integer matricule;
	private Set<ClientDAO> listeClients = new HashSet<ClientDAO>();
	
	
	public Integer getMatricule() {
		return matricule;
	}
	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}
	public Set<ClientDAO> getListeClients() {
		return listeClients;
	}
	public void setListeClients(Set<ClientDAO> listeClients) {
		this.listeClients = listeClients;
	}
	
	
	@Override
	public String toString() {
		return "EmployeDAO [matricule=" + matricule + ", listeClient=" + listeClients
				+ "]";
	}
	
	
	
	
}





