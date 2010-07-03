package fr.afcepf.ai77.g1.presentation.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesChoixContratDTO;
import fr.afcepf.ai77.g1.persistence.entity.Formule;
import fr.afcepf.ai77.g1.persistence.entity.TypeAutomate;


/**
 * ici on a tout ce qui est nom de formules, catalogue, listes qui chargent pour que le client choisissent ce qu'il veut
 * @author Daful 06 66327874
 *
 */
public class ChoixContratBean {
	private List<SelectItem> formules = new ArrayList<SelectItem>();
	private List<SelectItem> machines = new ArrayList<SelectItem>();
	private List<TypeAutomate> machinesDispo = new ArrayList<TypeAutomate>();
	private String selectedFormule;
	private String selectedMachine;
	public String getSelectedMachine() {
		return selectedMachine;
	}



	public void setSelectedMachine(String selectedMachine) {
		this.selectedMachine = selectedMachine;
	}

	private List<Formule> formulesList;
	public List<SelectItem> getMachines() {
		return machines;
	}

	private String description;




	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public List<SelectItem> getFormules() {
		return formules;
	}
	

	
	public String getSelectedFormule() {
		return selectedFormule;
	}
	public void setSelectedFormule(String selectedFormule) {
		this.selectedFormule = selectedFormule;
	}

	public String getDescriptionFormuleSelected() {
		return description;
	}
	public void setDescriptionFormuleSelected(String descriptionFormuleSelected) {
		this.description = descriptionFormuleSelected;
	}


	

public void getDescriptionMachine(){
	for (TypeAutomate automate: machinesDispo)
	{
		if(automate.getNom().equals(this.selectedMachine))
		{
			description= "Description de la machine :" +selectedMachine + " : "+ automate.getDescription();
		}
	}
}


	public void getDescriptionFormule(){

		{
			for (Formule formule : formulesList) {
				if (formule.getLibelleFormule().equals(this.selectedFormule))
				{
					description= "Description de la formule "+ selectedFormule+ " : "+ formule.getCommentaireFormule();
				}
			}
		}


		//	descriptionFormuleSelected="lala";
	}

	public ChoixContratBean(){
		IDonneesChoixContratDTO  donneesContrat = DTOFactory.getIDonneesChoixContratDTO();
		formulesList= donneesContrat.getAllGeneral();

		for (Formule formule : formulesList) {
			SelectItem si = new SelectItem();
			si.setLabel(formule.getLibelleFormule());
			si.setDescription(formule.getLibelleFormule());
			si.setValue(formule.getLibelleFormule());
			formules.add(si);
		}
		
		machinesDispo= donneesContrat.getAllMachines();
		for (TypeAutomate machine : machinesDispo) {
			SelectItem si = new SelectItem();
			si.setLabel(machine.getNom());
			si.setDescription(machine.getNom());
			si.setValue(machine.getNom());
			machines.add(si);
		}



	}

}
