package fr.afcepf.ai77.g1.metiers.implementations;

import java.util.List;

import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesContratDTO;
import fr.afcepf.ai77.g1.persistence.entity.Formule;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesContratDAO;

public class DonneesContratDTOImpl implements IDonneesContratDTO {

	
private IDonneesContratDAO donneesContrat = null;
	

	public IDonneesContratDAO getDonneesClient() {
		return donneesContrat;
	}


	public void setDonneesContrat(IDonneesContratDAO donneesContrat) {
		this.donneesContrat = donneesContrat;
	}

	@Override
	public ContratDTO getContrat() {
		
		ContratDTO contratdto = new ContratDTO();
		List<Formule> listeToutesFormules= getDonneesClient().getAllFormule();
		contratdto.setFormule(listeToutesFormules);
		return contratdto;
	}

}
