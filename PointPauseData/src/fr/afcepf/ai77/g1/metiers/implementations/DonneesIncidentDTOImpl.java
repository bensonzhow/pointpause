package fr.afcepf.ai77.g1.metiers.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.jgroups.SetStateEvent;
import org.springframework.beans.BeanUtils;

import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.IncidentDTO;
import fr.afcepf.ai77.g1.metiers.dto.InterventionDTO;
import fr.afcepf.ai77.g1.metiers.dto.ListeContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.ListeMachineDTO;
import fr.afcepf.ai77.g1.metiers.dto.ListeMachinesDTO;
import fr.afcepf.ai77.g1.metiers.dto.StatutIncidentDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesIncidentDTO;
import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.Incident;
import fr.afcepf.ai77.g1.persistence.entity.Installation;
import fr.afcepf.ai77.g1.persistence.entity.StatutIncident;
import fr.afcepf.ai77.g1.persistence.entity.TypeAutomate;
import fr.afcepf.ai77.g1.persistence.entity.TypePb;
import fr.afcepf.ai77.g1.persistence.implementations.DonneesClientDAOImpl;
import fr.afcepf.ai77.g1.persistence.implementations.DonneesContratDAOImpl;
import fr.afcepf.ai77.g1.persistence.implementations.DonneesIncidentDAOImpl;
import fr.afcepf.ai77.g1.persistence.implementations.DonneesTypePbDAOImpl;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesInstallationDAO;

public class DonneesIncidentDTOImpl implements IDonneesIncidentDTO {

	private DonneesIncidentDAOImpl donneesIncident = null;
	private DonneesClientDAOImpl donneesClient = null;
	private DonneesTypePbDAOImpl donneesTypePb = null;
	private DonneesContratDAOImpl donneesContrat = null;
	private IDonneesInstallationDAO donneesInstallation = null;


	/*--------------------------Getters & Setters-----------------------------------*/

	public IDonneesInstallationDAO getDonneesInstallation() {
		return donneesInstallation;
	}

	public void setDonneesInstallation(IDonneesInstallationDAO donneesInstallation) {
		this.donneesInstallation = donneesInstallation;
	}

	public DonneesContratDAOImpl getDonneesContrat() {
		return donneesContrat;
	}

	public void setDonneesContrat(DonneesContratDAOImpl donneesContrat) {
		this.donneesContrat = donneesContrat;
	}

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
		// Incident incident =
		// getDonneesIncident().getIncidentDTOByNumero(numero);
		//
		return null;
	}

	@Override
	public Integer insertIncident(IncidentDTO iDTO) {

		Client c = donneesClient.getClientByNumero(iDTO.getNumClient());
		TypePb tp = donneesTypePb.getTypePbByNumero(iDTO.getNumTypePb());
		Installation installation = donneesInstallation.getInstallation(iDTO.getNumInstallation());

		Incident incident = new Incident();
		incident.setClient(c);
		incident.setTypePb(tp);
		incident.setNumeroDeploiement(installation);
		installation.getListeIncidents().add(incident);
		incident.setDateDeclarationIncident(iDTO.getDateDeclarationIncident());
		incident.setDateConstatIncident(iDTO.getDateConstatIncident());
		incident.setFlag(iDTO.getFlag());

		Integer res = donneesIncident.insertIncident(incident);

		return res;
	}

	@Override
	public ListeMachineDTO getNumMachineByNumContrat(int numContrat) {
		List<TypeAutomate> listeMachine = donneesContrat
				.getNumMachineByNumContrat(numContrat);
		ListeMachineDTO listeMachineDTO = new ListeMachineDTO();
		for(TypeAutomate ta : listeMachine){
			listeMachineDTO.getListeMachine().add(ta.getId());
		}
		return listeMachineDTO;
	}
	
	@Override
	public ListeContratDTO getContratsByNumClient(int numClient) {
		List<Contrat> listeContrat = donneesClient
				.getNumContratbyNumClient(numClient);
		ListeContratDTO listeContratDTO = new ListeContratDTO();
		for (Contrat c : listeContrat) {
			listeContratDTO.getListeContrat().add(c.getNumero());
		}
		return listeContratDTO;
	}

	public ListeMachinesDTO getMachinesByNumClient(int numClient) {
		List<Installation> listeInstallation = donneesClient
				.getInstallationByNumClient(numClient);

		if (listeInstallation == null)
			return null;

		ListeMachinesDTO listeMachines = new ListeMachinesDTO();

		for (Installation instal : listeInstallation) {
			listeMachines.getListeMachines().add(instal.getNumero());
		}

		return listeMachines;
	}

	@Override
	public List<IncidentDTO> getHistoriqueIncidentByClient(int numClient) {
		// TODO Auto-generated method stub

		List<Incident> listIncident = donneesIncident
				.getSuiviIncidentByClient(numClient);

		List<Integer> listNumInstall = new Vector<Integer>();

		for (Incident inc : listIncident) {
			listNumInstall.add(inc.getNumeroDeploiement().getNumero());
		}
		
		
		List<Contrat> listContrat = donneesContrat
				.getListContratFromListNumInstallation(listNumInstall);
	

		// on prepare la liste de DTO. On utilise une double boucle
		// pour associer les numeros de contrat avec les incidentsDTO

		// Ce dernier point n'est pas safe du tout.

		List<IncidentDTO> listIncidentDTO = new Vector<IncidentDTO>();

		Iterator<Incident> iterIncident = listIncident.iterator();
		Iterator<Contrat> iterContrat = listContrat.iterator();

		while (iterIncident.hasNext()) {
			Incident incident = iterIncident.next();
			Contrat contrat = iterContrat.next();

			IncidentDTO newIncDto = new IncidentDTO();

			newIncDto.setDateConstatIncident(incident.getDateConstatIncident());
			newIncDto.setDateDeclarationIncident(incident.getDateDeclarationIncident());
			newIncDto.setFlag(incident.getFlag());
			newIncDto.setNumClient(numClient);
			newIncDto.setNumero(incident.getNumero());
			newIncDto.setNumInstallation(incident.getNumeroDeploiement().getNumero());
			
			try{
				newIncDto.setLibelTypePb(incident.getTypePb().getLibelle());
			}catch(Exception e){
				newIncDto.setLibelTypePb("inconnu");
			}
			

			try {
				newIncDto.setNumTypePb(incident.getTypePb().getNumTypePb());
			} catch (Exception e) {
				newIncDto.setNumTypePb(-1);
			}

			// c'est ici que c'est pas safe
			try {
				newIncDto.setNumContrat(contrat.getNumero());
			} catch (Exception e) {
				newIncDto.setNumContrat(-1);
			}

			// il faut s'occuper de ses statut incident

			for (StatutIncident stinc : incident.getListeStatutsIncidents()) {
				StatutIncidentDTO stincdto = new StatutIncidentDTO();

				stincdto.setCommentaire(stinc.getCommentaire());
				stincdto.setDateNouveauStatut(stinc.getDateChangementStatut());
				stincdto.setNumero(stinc.getNumero());
				
			
				try{
					stincdto.setStatut(stinc.getTypeStatut().getLibelle());
					stincdto.setIntStatut(stinc.getTypeStatut().getNumeroType());
				}catch(Exception e){
					stincdto.setStatut("indetermine");
					stincdto.setIntStatut(-1);
				}

				// FIXME
				/*
				 * 
				 * stincdto.setStatut(stinc.getTypeStatutIncident().getLibelle());
				 */

				// ajouter les interventions
				if (stinc.getIntervention() != null) {
					InterventionDTO intervDTO = new InterventionDTO();

					intervDTO.setCommentaire(stinc.getIntervention().getCommentaire());
					intervDTO.setDebutIntervention(stinc.getIntervention().getDateDebutIntervention());
					intervDTO.setFinIntervention(stinc.getIntervention().getDateFinIntervention());

					// FIXME : mapper le nom de l'employe
					/*
					try{					  
					  intervDTO.setNomEmploye(stinc.getIntervention().getEmploye().getNom());
					}catch(Exception e){
						intervDTO.setNomEmploye("aucun employe defini");
					}
					*/
					
					 
					stincdto.setIntervention(intervDTO);
				}

				newIncDto.getHistorique().add(stincdto);


			}

			//trier la liste des statutincidents
			newIncDto.sortMyStatus();
			
			//mettre dans l'incident directement
			
			StatutIncidentDTO statutDTO = newIncDto.getLastStatutDTO(); 
			if(statutDTO!=null){
				newIncDto.setStatutPriseEnCharge(statutDTO.getIntStatut());
				newIncDto.setLibelStatutPriseEnCharge(statutDTO.getStatut());
			}else{
				newIncDto.setStatutPriseEnCharge(-1);
				newIncDto.setLibelStatutPriseEnCharge("indetermine");				
			}
			
			listIncidentDTO.add(newIncDto);

		}

		return listIncidentDTO;
	}

	@Override
	public boolean switchIncidentFlag(int numIncident) {
		// TODO Auto-generated method stub
		
		Incident inc = donneesIncident.getIncidentByNumero(numIncident);
		inc.setFlag(! inc.getFlag());
		boolean res = donneesIncident.updateIncident(inc);
		
		return res;
	}

	@Override
	public List<String> getListtypePb() {
		List<String> liste = new ArrayList<String>();
			try {
				liste = donneesTypePb.getTypePb();
			} catch (Exception e) {
				System.out.println("DTO : Récupération impossible des types de problème...");
			}
		return liste;
	}

}
