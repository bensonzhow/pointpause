package fr.afcepf.ai77.g1.persistence.interfaces;

import fr.afcepf.ai77.g1.persistence.entity.Client;

public interface IDonneesClientDAO {
	Client getClientByNumero(int numero);
	Client getClientBySession(String login, String password);
	
}
