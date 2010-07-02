package fr.afcepf.ai77.g1.presentation.bean;

import java.util.ArrayList;
import java.util.List;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesSessionDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesChoixContratDTO;
import fr.afcepf.ai77.g1.persistence.entity.Formule;


/**
 * ici on a tout ce qui est nom de formules, catalogue, listes qui chargent pour que le client choisissent ce qu'il veut
 * @author Daful 06 66327874
 *
 */
public class ChoixContratBean {
	private List<String> formules = new ArrayList<String>();

	public List<String> getFormules() {
		return formules;
	}

	public void setFormules(List<String> formules) {
		this.formules = formules;}


	public ChoixContratBean(){
		IDonneesChoixContratDTO  donneesSession = DTOFactory.getIDonneesChoixContratDTO();
		List<Formule> formulesList= donneesSession.getAllGeneral();
		List<String> formulesLocal = new ArrayList<String>();;
		for (Formule formule : formulesList) {
				formulesLocal.add(formule.getLibelleFormule());	
		}
		this.setFormules(formulesLocal);

	}

}
