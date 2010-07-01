package fr.afcepf.ai77.g1.persistence.entity;

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
public class Employe {
	
	private Integer matricule=null;
	private Set<Client> listeClients = new HashSet<Client>();
	
	
	public Integer getMatricule() {
		return matricule;
	}
	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}
	public Set<Client> getListeClients() {
		return listeClients;
	}
	public void setListeClients(Set<Client> listeClients) {
		this.listeClients = listeClients;
	}
	
	
	@Override
	public String toString() {
		return "Employe [matricule=" + matricule + ", listeClient=" + listeClients
				+ "]";
	}
	
	
	public Employe(){
		
	}
	
}





