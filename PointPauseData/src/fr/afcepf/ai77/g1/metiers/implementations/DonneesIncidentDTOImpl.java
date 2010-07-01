package fr.afcepf.ai77.g1.metiers.implementations;

import java.util.Date;

import fr.afcepf.ai77.g1.metiers.dto.IncidentDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesIncidentDTO;
import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Incident;
import fr.afcepf.ai77.g1.persistence.implementations.DonneesClientDAOImpl;
import fr.afcepf.ai77.g1.persistence.implementations.DonneesIncidentDAOImpl;

public class DonneesIncidentDTOImpl implements IDonneesIncidentDTO {

	private DonneesIncidentDAOImpl donneesIncident = null;
	private DonneesClientDAOImpl donneesClient = null;
	
	
	/*--------------------------Getters & Setters-----------------------------------*/
	
	public DonneesClientDAOImpl getDonneesClient() {
		return donneesClient;
	}
	public void setDonneesClient(DonneesClientDAOImpl donneesClient) {
		this.donneesClient = donneesClient;
	}
	
	public DonneesIncidentDAOImpl getDonneesIncident() {
		return donneesIncident;
	}
	public void setDonneesIncident(DonneesIncidentDAOImpl donneesIncident) {
		this.donneesIncident = donneesIncident;
	}
	
	/*--------------------------------METHODES-------------------------------------*/

	@Override
	public IncidentDTO getIncidentDTOByNumero(int numero) {
//		Incident incident = getDonneesIncident().getIncidentDTOByNumero(numero);
//		
		return null;
	}

	
	@Override
	public Integer insertIncident(IncidentDTO iDTO) {
		
		Client c = donneesClient.getClientByNumero(iDTO.getNumClient());
		//TypeProbleme tp = donneesTypePb.getTypePbByNumero(iDTO.getNumTypePb());
		
		Incident incident = new Incident();
		incident.setClient(c);
		//incident.setTypePb(tp);
		incident.setDateDeclarationIncident(iDTO.getDateDeclarationIncident());
		incident.setDateConstatIncident(iDTO.getDateConstatIncident());
		incident.setFlag(iDTO.getFlag());
		
		Integer res = donneesIncident.insertIncident(incident);
		
		
		return res;
	}
	

}
