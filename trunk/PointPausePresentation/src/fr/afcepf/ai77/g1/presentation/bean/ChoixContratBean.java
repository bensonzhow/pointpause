package fr.afcepf.ai77.g1.presentation.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.ListeContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesChoixContratDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesContratDTO;

import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesIncidentDTO;
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
	public String commentaire;
	private String test;
	private Boolean flag;
	private Date dateFin ;
	private Date dateDebut;
	
	private String check;
	private Boolean suite;
	private Boolean essaiValid = false;
	private Integer frequence;
	private String descriptionFormule="";
	private String descriptionMachine="";
	private List<SelectItem> formules = new ArrayList<SelectItem>();
	private List<SelectItem> machines = new ArrayList<SelectItem>();
	private List<ModeleAutomate> machinesDispo = new ArrayList<ModeleAutomate>();
	private String selectedFormule;
	private String selectedMachine;
	private String region;
	private int quantite =1;
	private Integer verdict;
	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
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

	}
	public Integer Inserer(){
		System.out.println("inserer");
		System.out.println("test= "+ test);
		System.out.println("region"+ region);
		//	System.out.println(dateDebut);
	System.out.println("commentaire:"+commentaire);
		System.out.println("quantite"+quantite);
		System.out.println("commentaire");
		IDonneesContratDTO donneesContrat = DTOFactory.getIDonneesContratDTO();		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
	
		HttpSession httpSession = request.getSession(false);
		
		SessionDTO session = (SessionDTO)httpSession.getAttribute("session");
		ContratDTO contrat = new ContratDTO();
		contrat.setFreqApprovisionnement(frequence);
		System.out.println("commentaire");
		
		contrat.setDateDebut(dateDebut);
		contrat.setFlag(flag);
			contrat.setDateFin(dateFin);
				
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateDebut);
		int d1 = cal.get(Calendar.DATE);
		cal.setTime(dateFin);
		int d2 = cal.get(Calendar.DATE);
		int duree= d2 - d1;
		contrat.setDuree(duree);
		contrat.setCommentaire(commentaire);
		contrat.setGarantie(true);
		contrat.setNumClient(session.getNumeroClient());
		System.out.println("fin insertcontrat ");
		return setVerdict(donneesContrat.insertContrat(contrat));
		
	}
	
	
	public Boolean Submit1(){
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
		suite=true;
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

	public Boolean getSuite() {
		return suite;
	}

	public void setSuite(Boolean suite) {
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

	public void setFrequence(Integer frequence) {
		this.frequence = frequence;
	}

	public Integer getFrequence() {
		return frequence;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Boolean getFlag() {
		return flag;
	}

	
	public Integer setVerdict(Integer verdict) {
		this.verdict = verdict;
		return verdict;
	}

	public Integer getVerdict() {
		return verdict;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getTest() {
		return test;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

}
