package fr.afcepf.ai77.g1.metiers.implementations;

import java.util.List;

import fr.afcepf.ai77.g1.metiers.dto.BouquetDTO;
import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesChoixContratDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesContratDTO;
import fr.afcepf.ai77.g1.persistence.entity.Bouquet;
import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.Formule;
import fr.afcepf.ai77.g1.persistence.entity.Incident;
import fr.afcepf.ai77.g1.persistence.entity.ModeleAutomate;
import fr.afcepf.ai77.g1.persistence.entity.TypePb;
import fr.afcepf.ai77.g1.persistence.implementations.DonneesClientDAOImpl;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesChoixContratDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesContratDAO;

public class DonneesContratDTOImpl implements IDonneesContratDTO {

	private IDonneesClientDAO donneesClient = null;
	
	private IDonneesChoixContratDAO donneesChoixContrat=null;
	
	private IDonneesContratDAO donneesContrat = null;
	

public IDonneesChoixContratDAO getDonneesChoixContrat() {
		return donneesChoixContrat;
	}

	public void setDonneesChoixContrat(IDonneesChoixContratDAO donneesChoixContrat) {
		this.donneesChoixContrat = donneesChoixContrat;
	}
	public IDonneesContratDAO getDonneesContrat() {
		return donneesContrat;
	}

	public IDonneesClientDAO getDonneesClient() {
		return donneesClient;
	}


	public void setDonneesClient(IDonneesClientDAO donneesClient) {
		this.donneesClient = donneesClient;
	}


	public void setDonneesContrat(IDonneesContratDAO donneesContrat) {
		this.donneesContrat = donneesContrat;
	}
	@Override
	public Integer insertContrat(ContratDTO contratDTO, BouquetDTO bouquetDTO){
		Client c = donneesClient.getClientByNumero(contratDTO.getNumClient());
		Formule f = donneesChoixContrat.getFormuleById(bouquetDTO.getCodeFormule());
		ModeleAutomate a = donneesChoixContrat.getAutomateById(bouquetDTO.getCodemodeleAutomate());
		Contrat contrat = new Contrat();
		Bouquet bouquet = new Bouquet();
		contrat.setClient(c);
		contrat.setCommentaire(contratDTO.getCommentaire());
		contrat.setDateDebut(contratDTO.getDateDebut());
		contrat.setDateFin(contratDTO.getDateFin());
		contrat.setDuree(contratDTO.getDuree());
		contrat.setFlag(contratDTO.getFlag());
		contrat.setFreqApprovisionnement(contratDTO.getFreqApprovisionnement());
		contrat.setGarantie(contratDTO.getGarantie());
		contrat.setFlag(contratDTO.getFlag());
		bouquet.setContrat(contrat);
		bouquet.setFormule(f);
		bouquet.setModeleAutomate(a);
		bouquet.setQuantite(bouquetDTO.getQuantite());
		Integer numContrat = donneesContrat.insertContrat(contrat);
		Integer numBouquet = donneesContrat.insertBouquet(bouquet);
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
