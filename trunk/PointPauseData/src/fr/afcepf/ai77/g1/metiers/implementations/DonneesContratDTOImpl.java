package fr.afcepf.ai77.g1.metiers.implementations;

import java.util.List;

import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesContratDTO;
import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.Formule;
import fr.afcepf.ai77.g1.persistence.entity.Incident;
import fr.afcepf.ai77.g1.persistence.entity.TypePb;
import fr.afcepf.ai77.g1.persistence.implementations.DonneesClientDAOImpl;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesContratDAO;

public class DonneesContratDTOImpl implements IDonneesContratDTO {

	private DonneesClientDAOImpl donneesClient = null;
	private IDonneesContratDAO donneesContrat = null;
	

	public IDonneesContratDAO getDonneesContrat() {
		return donneesContrat;
	}


	public DonneesClientDAOImpl getDonneesClient() {
		return donneesClient;
	}


	public void setDonneesClient(DonneesClientDAOImpl donneesClient) {
		this.donneesClient = donneesClient;
	}


	public void setDonneesContrat(IDonneesContratDAO donneesContrat) {
		this.donneesContrat = donneesContrat;
	}
	@Override
	public Integer insertContrat(ContratDTO contratDTO){
		Client c = donneesClient.getClientByNumero(contratDTO.getNumClient());
		Contrat contrat = new Contrat();
		contrat.setClient(c);
		contrat.setCommentaire(contratDTO.getCommentaire());
		contrat.setDateDebut(contratDTO.getDateDebut());
		contrat.setDateFin(contratDTO.getDateFin());
		contrat.setDuree(contratDTO.getDuree());
		contrat.setFlag(contratDTO.getFlag());
		contrat.setFreqApprovisionnement(contratDTO.getFreqApprovisionnement());
		contrat.setGarantie(contratDTO.getGarantie());
		contrat.setFlag(contratDTO.getFlag());
		Integer numContrat = donneesContrat.insertContrat(contrat);
		return numContrat;
		
	}
	@Override
	public ContratDTO getContrat() {
		return null;
		
		
	}

	@Override
	public List<Integer> getListeMachineByContrat(int numContratDTO) {
		List<Integer> listeMachine = donneesContrat.listeNumMachineByNumContrat(numContratDTO);
		return listeMachine;
	}

}
