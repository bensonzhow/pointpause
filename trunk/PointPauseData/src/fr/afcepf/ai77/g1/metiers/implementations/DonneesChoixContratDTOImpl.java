package fr.afcepf.ai77.g1.metiers.implementations;

import java.util.List;

import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesChoixContratDTO;
import fr.afcepf.ai77.g1.persistence.entity.Formule;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesChoixContratDAO;


public class DonneesChoixContratDTOImpl implements IDonneesChoixContratDTO {

private IDonneesChoixContratDAO donneesChoixContrat = null;
	


	public IDonneesChoixContratDAO getDonneesChoixContrat() {
	return donneesChoixContrat;
}



public void setDonneesChoixContrat(IDonneesChoixContratDAO donneesChoixContrat) {
	this.donneesChoixContrat = donneesChoixContrat;
}



	@Override
	public List<Formule> getAllGeneral() {
		List<Formule> lf = donneesChoixContrat.getAllGeneralFormules();
		return lf;
	}

}
