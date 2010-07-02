package fr.afcepf.ai77.g1.persistence.interfaces;

import java.util.List;

import fr.afcepf.ai77.g1.persistence.entity.Incident;

public interface IDonneesIncidentDAO {
	
	Incident getIncidentByNumero(int numero);
	List<Incident> getIncidentByContrat(int numContrat);
	Integer insertIncident(Incident incident);
	
	
	
	/*
	 * cette m�thode va remonter tous les incidents du client, ainsi que les statuts incidents
	 * et interventions eventuellement associ�es
	 * 
	 */
	List<Incident> getSuiviIncidentByClient(Integer clientID);
	
	
}
