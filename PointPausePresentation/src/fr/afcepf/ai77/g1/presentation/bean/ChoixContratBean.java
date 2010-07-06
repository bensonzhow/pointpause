package fr.afcepf.ai77.g1.presentation.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.BouquetDTO;
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
	String avert;
	Boolean alertBool;
	public Boolean getAlertBool() {
		return alertBool;
	}


	public void setAlertBool(Boolean alertBool) {
		this.alertBool = alertBool;
	}
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
			.getExternalContext().getRequest();
	HttpSession httpSession = request.getSession(false);
	public String commentaire;
	private String[] reponseFormule;
	//private int nbCommande=1; 
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
	

	public Integer getDescriptionMachineAjax(){
	essaiValid=false;
	Integer idMachine=0;
	for (ModeleAutomate automate: machinesDispo)
	{
		if(automate.getNom().equals(this.selectedMachine))
		{
			descriptionMachine= "Description de la machine :" +selectedMachine + " : "+ automate.getDescription();
			idMachine = automate.getId();
		}
	}
	return idMachine;
	
}


	public String getDescriptionFormule() {
	return descriptionFormule;
}

public String getDescriptionMachine() {
	return descriptionMachine;
}
/*
 * retourne le code formule 
 */
	public Integer getDescriptionFormuleAjax(){

		{
			essaiValid=false;
			Integer codeFormule = 0; 
			for (Formule formule : formulesList) {
				if (formule.getLibelleFormule().equals(this.selectedFormule))
				{
					descriptionFormule= "Description de la formule "+ selectedFormule+ " : "+ formule.getCommentaireFormule();
					codeFormule =formule.getCodeFormule();
				}
			}
			return codeFormule;
		}

	}
	/*public void NouvelleCommande(){
		reponseFormule[1]="reponseFormule"+
		nbCommande++;
		suite=true;
	}*/
	
	public String Inserer(){
		System.out.println("inserer");
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
		BouquetDTO bouquet = new BouquetDTO();
		
		bouquet.setCodeFormule(getDescriptionFormuleAjax());
		bouquet.setCodemodeleAutomate(getDescriptionMachineAjax());
		bouquet.setQuantite(quantite);
		
		contrat.setFreqApprovisionnement(frequence);
		System.out.println("commentaire");
		
		contrat.setDateDebut(dateDebut);
		contrat.setFlag(flag);
			contrat.setDateFin(dateFin);
			long duree = dateFin.getTime()- dateDebut.getTime();
			int dureeJours= (int)TimeUnit.DAYS.convert(duree,TimeUnit.MILLISECONDS);
		if(dureeJours<180){
			verifierDuree();
			return "Failure";
		}
		contrat.setDuree(dureeJours);
		contrat.setCommentaire(commentaire);
		contrat.setGarantie(true);
		contrat.setNumClient(session.getNumeroClient());
		System.out.println("fin insertcontrat ");
		
			verdict= donneesContrat.insertContrat(contrat, bouquet);
			if(verdict>0)
				httpSession.removeAttribute("ChoixContratBean");
		return  verdict > 0 ? "OK" : "Failure";
		
	}
	
	public void verifierDuree(){
		System.out.println("on time selected");
		System.out.println("date fin: "+ dateFin);
		System.out.println("date debut : "+dateDebut);
		if(dateDebut==null)
		{
			alertBool=true;
			avert="choisir une date de début aussi...";
			return;
		}
		if(dateFin==null){
			alertBool=false;
			return;
		}
		long duree = dateFin.getTime()- dateDebut.getTime();
		int dureeJours= (int)TimeUnit.DAYS.convert(duree,TimeUnit.MILLISECONDS);
	    
		if(dureeJours<180){
			alertBool=true;
			avert="votre contrat doit faire plus de 6 mois";
		}
		else{
			alertBool=false;
			avert="";
		}
	}
	public void update()
	{
		System.out.println("update");
		System.out.println("formule sel " +selectedFormule);
		System.out.println(dateDebut);
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
			si.setLabel(formule.getCodeFormule().toString());
			//si.setDescription(formule.getCommentaireFormule());
			si.setValue(formule.getLibelleFormule());
			
			formules.add(si);
		}
		
		machinesDispo= donneesContrat.getAllMachines();
		for (ModeleAutomate machine : machinesDispo) {
			SelectItem si = new SelectItem();
			si.setLabel(machine.getId().toString());
		//	si.setDescription(machine.getDescription());
			si.setValue(machine.getNom());
			machines.add(si);
		}



	}

	public Boolean getSuite() {
		return suite;
	}

	public String getAvert() {
		return avert;
	}


	public void setAvert(String avert) {
		this.avert = avert;
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

//	public void setNbCommande(int nbCommande) {
//		this.nbCommande = nbCommande;
//	}
//
//	public int getNbCommande() {
//		return nbCommande;
//	}
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


	public void setReponseFormule(String[] reponseFormule) {
		this.reponseFormule = reponseFormule;
	}


	public String[] getReponseFormule() {
		return reponseFormule;
	}
}
