package fr.afcepf.ai77.g1.metiers.implementations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.afcepf.ai77.g1.metiers.dto.BouquetDTO;
import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.ListeContratDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesChoixContratDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesContratDTO;
import fr.afcepf.ai77.g1.persistence.entity.Bouquet;
import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.Formule;
import fr.afcepf.ai77.g1.persistence.entity.Incident;
import fr.afcepf.ai77.g1.persistence.entity.LoadingPolicy;
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
		contrat.getListeBouquets().add(bouquet);
		bouquet.setContrat(contrat);
		bouquet.setFormule(f);
		bouquet.setModeleAutomate(a);
		bouquet.setQuantite(bouquetDTO.getQuantite());
		Integer numContrat = donneesContrat.insertContrat(contrat);
		//	Integer numBouquet = donneesContrat.insertBouquet(bouquet);
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

//sert surtout pour le flag /deflag
@Override
public Boolean updateContrat(ContratDTO contratdto){
	Contrat c = donneesContrat.getContratById(contratdto.getNumero());
	c.setFlag(contratdto.getFlag());
	Boolean b;
	 b = donneesContrat.updateContrat(c);
	 return b;
	
}
@Override
public ContratDTO getContratById(int numContrat){
	Contrat contrat = donneesContrat.getContratById(numContrat);
	ContratDTO cdto = copyContrat(contrat);
	return cdto;
}

@Override
public ContratDTO getContratBouquetById(int numContrat){
	LoadingPolicy policy = new LoadingPolicy();
	policy.getPolicies().add("bouquet");
	Contrat contrat = donneesContrat.getContratById(numContrat,policy);
	ContratDTO cdto = copyContrat(contrat);
	
	return cdto;
}


	@Override
	public List<ContratDTO> getSyntheseContratbyClient(int numClient) {
		// TODO Auto-generated method stub

		List<ContratDTO> listeContDt = new Vector<ContratDTO>();

		List<Contrat> listeDAO = donneesContrat.getAllContratBouquetInstallByClient(numClient);

		if (listeDAO==null) return null;


		for (Contrat contrat : listeDAO){

			ContratDTO contDt = copyContrat(contrat);


			for (Bouquet bouquet : contrat.getListeBouquets()){
				BouquetDTO bdto = copyBouquet(bouquet);
				contDt.getListeBouquets().add(bdto);
			}

			listeContDt.add(contDt);
		}

		return listeContDt;
	}

	@Override
	public List<ContratDTO> getLastContratPourTableau(int numClient) {
		List<Contrat> contrats = donneesContrat.getLastContratsBouquetInstallByClient(numClient);
		List<ContratDTO> contratsDTO = new ArrayList<ContratDTO>();
		for (Contrat contrat : contrats) {
			ContratDTO contratDTO = new ContratDTO();
			//ça va meme si null va setter null au dto, par contre pas pour les objets faut les tester genre bouquets et client
			contratDTO.setDateDebut(contrat.getDateDebut());
			contratDTO.setDateFin(contrat.getDateFin());
			contratDTO.setDuree(contrat.getDuree());
			contratDTO.setCommentaire(contrat.getCommentaire());
			contratDTO.setFlag(contrat.getFlag());
			contratDTO.setFreqApprovisionnement(contrat.getFreqApprovisionnement());
			contratDTO.setGarantie(contrat.getGarantie());
			contratDTO.setNumero(contrat.getNumero());
			if(contrat.getClient()!=null)
				contratDTO.setNumClient(contrat.getClient().getNumero());
			contratsDTO.add(contratDTO);
			//TODO pour l'instant on ne récupère pas les boquuets liés à un contrat, il faudra le faire
			//if(contrat.getListeBouquets()!=null)
			//à faire : faudra boucler sur la liste des bouquets contrats et les setter dans les bouquetDTO de contrat DTO horrible !!
			//contratDTO.setListeBouquets(contrat.getListeBouquets());

		}
		return contratsDTO;
	}

	@Override
	public List<ContratDTO> getAllContratsBouquetInstallByClient(int numClient) {
		List<ContratDTO> allContratsDTO = new Vector<ContratDTO>();
		List<Contrat> listeContrat = donneesContrat.getAllContratBouquetInstallByClient(numClient);
		for (Contrat contrat : listeContrat) {
			ContratDTO cdto = copyContrat(contrat);
			allContratsDTO.add(cdto);
		}
		return allContratsDTO;
	}

	/*************************************************************************
	 * 
	 * sections utilitaires
	 * 
	 *************************************************************************/
	private BouquetDTO copyBouquet2(Bouquet bouquet){
		BouquetDTO bouquetDTO = new BouquetDTO();
		bouquetDTO.setCodeBouquet(bouquet.getCodeBouquet());
		bouquetDTO.setCodeFormule(bouquet.getFormule().getCodeFormule());
		
		bouquetDTO.setQuantite(bouquet.getQuantite());
		if (bouquet.getFormule()!=null)
		bouquetDTO.setStrFormule(bouquet.getFormule().getLibelleFormule());
		if (bouquet.getModeleAutomate()!=null)
		{
		bouquetDTO.setStrModeleAutomate(bouquet.getModeleAutomate().getNom());
		bouquetDTO.setCodemodeleAutomate(bouquet.getModeleAutomate().getId());}
		if(bouquet.getHistoriqueInstallations()!=null)
		bouquetDTO.setHistoriqueInstallations(bouquet.getHistoriqueInstallations());
		return bouquetDTO;
	}
	
	private ContratDTO copyContrat(Contrat contrat){
		ContratDTO cdto = new ContratDTO();
		List<BouquetDTO> listeBouquetDTO = new ArrayList<BouquetDTO>();
		cdto.setNumero(contrat.getNumero());
		cdto.setDateDebut(contrat.getDateDebut());
		cdto.setDateFin(contrat.getDateFin());
		cdto.setFreqApprovisionnement(contrat.getFreqApprovisionnement());
		cdto.setGarantie(contrat.getGarantie());
		cdto.setFlag(contrat.getFlag());
		cdto.setCommentaire(contrat.getCommentaire());
		if(contrat.getClient() !=null)
		cdto.setNumClient(contrat.getClient().getNumero());
		if(contrat.getListeBouquets()!=null){
			for (Bouquet bouquet : contrat.getListeBouquets()) {
				BouquetDTO bouquetDTO = copyBouquet2(bouquet);
				listeBouquetDTO.add(bouquetDTO);
			}
			if (listeBouquetDTO!=null)
			cdto.setListeBouquets(listeBouquetDTO);
		}

		return cdto;
	}
	
	private Contrat toContrat (ContratDTO contratDTO){
		Client c = donneesClient.getClientByNumero(contratDTO.getNumClient());
		//Formule f = donneesChoixContrat.getFormuleById(bouquetDTO.getCodeFormule());
		//ModeleAutomate a = donneesChoixContrat.getAutomateById(bouquetDTO.getCodemodeleAutomate());
		Contrat contrat = new Contrat();
		//Bouquet bouquet = new Bouquet();
		contrat.setClient(c);
		contrat.setCommentaire(contratDTO.getCommentaire());
		contrat.setDateDebut(contratDTO.getDateDebut());
		contrat.setDateFin(contratDTO.getDateFin());
		contrat.setDuree(contratDTO.getDuree());
		contrat.setFlag(contratDTO.getFlag());
		contrat.setFreqApprovisionnement(contratDTO.getFreqApprovisionnement());
		contrat.setGarantie(contratDTO.getGarantie());
		contrat.setFlag(contratDTO.getFlag());
		//contrat.getListeBouquets().add(bouquet);
//		bouquet.setContrat(contrat);
//		bouquet.setFormule(f);
//		bouquet.setModeleAutomate(a);
//		bouquet.setQuantite(bouquetDTO.getQuantite());
		return contrat;
	}

	private BouquetDTO copyBouquet(Bouquet bouquet){
		BouquetDTO bdto = new BouquetDTO();

		try{
			bdto.setStrFormule(bouquet.getFormule().getLibelleFormule());
		}catch(Exception e){
			bdto.setStrFormule("ind�termin�e");
		}

		try{
			bdto.setStrModeleAutomate(bouquet.getModeleAutomate().getNom());
		}catch(Exception e){
			bdto.setStrModeleAutomate("ind�termin�");
		}

		bdto.setQuantite(bouquet.getQuantite());

		return bdto;
	}

}
