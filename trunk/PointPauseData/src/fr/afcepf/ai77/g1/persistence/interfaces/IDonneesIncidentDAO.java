package fr.afcepf.ai77.g1.persistence.interfaces;

import java.util.List;

import fr.afcepf.ai77.g1.persistence.entity.Incident;
import fr.afcepf.ai77.g1.persistence.entity.LoadingPolicy;
import fr.afcepf.ai77.g1.persistence.entity.TypePb;
import fr.afcepf.ai77.g1.persistence.entity.TypeStatutIncident;

public interface IDonneesIncidentDAO {
	
	Incident getIncidentByNumero(int numero);
	
	/*policies acceptees : "installation", "statutIncident", "intervention"*/
	Incident getIncidentByNumero(int numero, LoadingPolicy policies);
	
	List<Incident> getIncidentByContrat(int numContrat);
	
	Integer insertIncident(Incident incident);
	
	boolean updateIncident(Incident incident);
	
	
	
	/*rechercher la liste des incidents pour un même client
	 * note : on initialisera automatiquement les statutincidents associés
	 */
	List<Incident> getSuiviIncidentByClient(Integer clientID);
	
	
	/*Variante, permet de filter lesquels sont termines*/	
	List<Incident> getSuiviIncidentByclient(Integer clientID, boolean unfinishedOnly);
	
	/*Variante, permettant de préciser quel intervalle */
	List<Incident> getSuiviIncidentByClient(Integer clientID, int min, int max);	
	
	/**********************************************************
	 * 
	 * La complete !
	 * 
	 * cette méthode va remonter tous les incidents du client, ainsi que les statuts incidents
	 * et interventions eventuellement associées.
	 * 
	 * Les données sont retournées triées par ordre descendant sur la date de déclaration.
	 * 
	 * unfinished : true -> on ne selectione que les interventions non terminees
	 * 				false-> on les prend toutes
	 * 
	 * min		: <0   -> on récupère le résultat depuis le début
	 * 			: >=0  -> on récupère le résultat que depuis le rang min
	 * 
	 * max 		: <0   -> on récupère depuis min jusqu'au dernier résultat
	 * 			: >=0  -> on récupère depuis min jusqu'à max, ou dernier résultat (ca dépend de ce qui arrive en premier) 
	 * 
	 * 
	 ************************************************************************ */
	List<Incident> getSuiviIncidentByClient(Integer clientID, boolean unfinishedOnly,int min, int max);	
	
	TypePb getTypePbById(int problemeId);
	
	TypeStatutIncident getTypeStatutIncidentById(int numeroStatut);
	

}
