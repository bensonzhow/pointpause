package fr.afcepf.ai77.g1.metiers.implementations;

import java.util.Date;
import java.util.List;

import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.IncidentDTO;
import fr.afcepf.ai77.g1.metiers.dto.ListeContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.ListeMachinesDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesIncidentDTO;
import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.Incident;
import fr.afcepf.ai77.g1.persistence.entity.Installation;
import fr.afcepf.ai77.g1.persistence.entity.TypePb;
import fr.afcepf.ai77.g1.persistence.implementations.DonneesClientDAOImpl;
import fr.afcepf.ai77.g1.persistence.implementations.DonneesIncidentDAOImpl;
import fr.afcepf.ai77.g1.persistence.implementations.DonneesTypePbDAOImpl;

public class DonneesIncidentDTOImpl implements IDonneesIncidentDTO {

	private DonneesIncidentDAOImpl donneesIncident = null;
	private DonneesClientDAOImpl donneesClient = null;
	private DonneesTypePbDAOImpl donneesTypePb = null;
	
	
	/*--------------------------Getters & Setters-----------------------------------*/
	
	public DonneesTypePbDAOImpl getDonneesTypePb() {
		return donneesTypePb;
	}
	public void setDonneesTypePb(DonneesTypePbDAOImpl donneesTypePb) {
		this.donneesTypePb = donneesTypePb;
	}
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
		TypePb tp = donneesTypePb.getTypePbByNumero(iDTO.getNumTypePb());

		Incident incident = new Incident();
		incident.setClient(c);
		incident.setTypePb(tp);
		incident.setDateDeclarationIncident(iDTO.getDateDeclarationIncident());
		incident.setDateConstatIncident(iDTO.getDateConstatIncident());
		incident.setFlag(iDTO.getFlag());
		
		Integer res = donneesIncident.insertIncident(incident);
		
		
		return res;
	}
	
	
	@Override
	public ListeContratDTO getContratsByNumClient(int numClient) {
		List<Contrat> listeContrat = donneesClient.getNumContratbyNumClient(numClient);
		ListeContratDTO listeContratDTO = new ListeContratDTO();
		for (Contrat c : listeContrat){
			listeContratDTO.getListeContrat().add(c.getNumero());
		}
		return listeContratDTO;
	}
	
	public ListeMachinesDTO getMachinesByNumClient(int numClient){
		List<Installation> listeInstallation = donneesClient.getInstallationByNumClient(numClient);
		
		if (listeInstallation==null) return null;
		
		ListeMachinesDTO listeMachines = new ListeMachinesDTO();
		
		for (Installation instal : listeInstallation){
			listeMachines.getListeMachines().add(instal.getNumero());
		}
		
		return listeMachines;
	}
	

}
