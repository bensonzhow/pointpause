package fr.afcepf.ai77.g1.persistence.interfaces;

import java.util.Collection;
import java.util.List;

import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Installation;

public interface IDonneesClientDAO {
	Client getClientByNumero(int numero);
	Client getClientBySession(String login, String password);
	boolean insertClient(Client c);
	List getNumContratbyNumClient(int numClient);
	List<Installation> getInstallationByNumClient(int numClient); 
}
