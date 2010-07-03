package fr.afcepf.ai77.g1.presentation.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesChoixContratDTO;
import fr.afcepf.ai77.g1.persistence.entity.Formule;


/**
 * ici on a tout ce qui est nom de formules, catalogue, listes qui chargent pour que le client choisissent ce qu'il veut
 * @author Daful 06 66327874
 *
 */
public class ChoixContratBean {
	private List<SelectItem> formules = new ArrayList<SelectItem>();

	
  public List<SelectItem> getFormules() {
		return formules;
	}
	public void setFormules(List<SelectItem> formules) {
		this.formules = formules;
	}

private String selectedFormule;
	public String getSelectedFormule() {
	return selectedFormule;
}
	public void setSelectedFormule(String selectedFormule) {
		this.selectedFormule = selectedFormule;
	}
	
private List<Formule> formulesList;


	private String descriptionFormuleSelected;

	

	public String getDescriptionFormuleSelected() {
		return descriptionFormuleSelected;
	}

	public void setDescriptionFormuleSelected(String descriptionFormuleSelected) {
		this.descriptionFormuleSelected = descriptionFormuleSelected;
	}



	public void getDescriptionFormule(){
		
		{
			for (Formule formule : formulesList) {
				if (formule.getLibelleFormule().equals(this.selectedFormule))
				{
					descriptionFormuleSelected= formule.getCommentaireFormule();
				}
			}


		}
		
		
	//	descriptionFormuleSelected="lala";
	}
	
	public ChoixContratBean(){
		IDonneesChoixContratDTO  donneesSession = DTOFactory.getIDonneesChoixContratDTO();
		 formulesList= donneesSession.getAllGeneral();
		
		for (Formule formule : formulesList) {
			SelectItem si = new SelectItem();
			si.setLabel(formule.getLibelleFormule());
			si.setDescription(formule.getLibelleFormule());
			si.setValue(formule.getLibelleFormule());
			formules.add(si);
		}
		


	}

}
