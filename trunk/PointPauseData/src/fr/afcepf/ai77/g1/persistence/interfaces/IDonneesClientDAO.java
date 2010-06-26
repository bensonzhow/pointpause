package fr.afcepf.ai77.g1.persistence.interfaces;

import fr.afcepf.ai77.g1.persistence.dao.ClientDAO;

public interface IDonneesClientDAO {
	ClientDAO getClientByNumero(int numero);
	
}
