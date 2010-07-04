package fr.afcepf.ai77.g1.presentation.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesChoixContratDTO;
import fr.afcepf.ai77.g1.persistence.entity.Formule;
import fr.afcepf.ai77.g1.persistence.entity.ModeleAutomate;



/**
 * ici on a tout ce qui est nom de formules, catalogue, listes qui chargent pour que le client choisissent ce qu'il veut
 * @author Daful 06 66327874
 *
 */
public class ChoixContratBean {
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
			.getExternalContext().getRequest();
	HttpSession httpSession = request.getSession(false);
	private String check;
	private String suite="false";
	private Boolean essaiValid = false;
	private String descriptionFormule="";
	private String descriptionMachine="";
	private List<SelectItem> formules = new ArrayList<SelectItem>();
	private List<SelectItem> machines = new ArrayList<SelectItem>();
	private List<ModeleAutomate> machinesDispo = new ArrayList<ModeleAutomate>();
	private String selectedFormule;
	private String selectedMachine;
	private String region;
	private int quantite =1;
	
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

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
	
	public List<SelectItem> getFormules() {
		return formules;
	}
	
	public String getSelectedFormule() {
		return selectedFormule;
	}
	public void setSelectedFormule(String selectedFormule) {
		this.selectedFormule = selectedFormule;
	}

	


	public void selectionChanged(){
		
	}

public void getDescriptionMachineAjax(){
	essaiValid=false;
	for (ModeleAutomate automate: machinesDispo)
	{
		if(automate.getNom().equals(this.selectedMachine))
		{
			descriptionMachine= "Description de la machine :" +selectedMachine + " : "+ automate.getDescription();
		}
	}
}


	public String getDescriptionFormule() {
	return descriptionFormule;
}

public String getDescriptionMachine() {
	return descriptionMachine;
}

	public void getDescriptionFormuleAjax(){

		{
			essaiValid=false;
			for (Formule formule : formulesList) {
				if (formule.getLibelleFormule().equals(this.selectedFormule))
				{
					descriptionFormule= "Description de la formule "+ selectedFormule+ " : "+ formule.getCommentaireFormule();
				}
			}
		}


		//	descriptionFormuleSelected="lala";
	}
	
	public String Submit1(){
		System.out.println("submit1");
		essaiValid=true;
		if(selectedFormule=="")
			{
			
			check= "choisir une formule d'abord ! ";
			return suite;}
		else if(selectedMachine=="")
			{check= "choisir une machine ! ";
		return suite;}
		else
			{check="ok";
			selectedFormule= "Formule choisie :" + selectedFormule;
		suite="true";
		return suite;}
		
	}
public void kill()
{
	httpSession.setAttribute("contratok", null);
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
		for (ModeleAutomate machine : machinesDispo) {
			SelectItem si = new SelectItem();
			si.setLabel(machine.getNom());
			si.setDescription(machine.getNom());
			si.setValue(machine.getNom());
			machines.add(si);
		}



	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getCheck() {
		return check;
	}

	public void setEssaiValid(Boolean essaiValid) {
		this.essaiValid = essaiValid;
	}

	public Boolean getEssaiValid() {
		return essaiValid;
	}

}
