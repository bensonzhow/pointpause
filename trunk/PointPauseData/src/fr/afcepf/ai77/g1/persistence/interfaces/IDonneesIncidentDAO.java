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
	
	
	
	/*rechercher la liste des incidents pour un m�me client
	 * note : on initialisera automatiquement les statutincidents associ�s
	 */
	List<Incident> getSuiviIncidentByClient(Integer clientID);
	
	
	/*Variante, permet de filter lesquels sont termines*/	
	List<Incident> getSuiviIncidentByclient(Integer clientID, boolean unfinishedOnly);
	
	/*Variante, permettant de pr�ciser quel intervalle */
	List<Incident> getSuiviIncidentByClient(Integer clientID, int min, int max);	
	
	/**********************************************************
	 * 
	 * La complete !
	 * 
	 * cette m�thode va remonter tous les incidents du client, ainsi que les statuts incidents
	 * et interventions eventuellement associ�es.
	 * 
	 * Les donn�es sont retourn�es tri�es par ordre descendant sur la date de d�claration.
	 * 
	 * unfinished : true -> on ne selectione que les interventions non terminees
	 * 				false-> on les prend toutes
	 * 
	 * min		: <0   -> on r�cup�re le r�sultat depuis le d�but
	 * 			: >=0  -> on r�cup�re le r�sultat que depuis le rang min
	 * 
	 * max 		: <0   -> on r�cup�re depuis min jusqu'au dernier r�sultat
	 * 			: >=0  -> on r�cup�re depuis min jusqu'� max, ou dernier r�sultat (ca d�pend de ce qui arrive en premier) 
	 * 
	 * 
	 ************************************************************************ */
	List<Incident> getSuiviIncidentByClient(Integer clientID, boolean unfinishedOnly,int min, int max);	
	
	TypePb getTypePbById(int problemeId);
	
	TypeStatutIncident getTypeStatutIncidentById(int numeroStatut);

	List<Incident> getLastIncidentByClient(int numClient);
	

}
