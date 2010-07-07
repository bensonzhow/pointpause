package fr.afcepf.ai77.g1.presentation.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.IncidentDTO;
import fr.afcepf.ai77.g1.metiers.dto.ListeContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesContratDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesIncidentDTO;

public class DeclarationIncidentBean {
	
	private Integer numMachine;
	private List numContrat;
	private List listMachine;
	private Date dateConstatIncident;
	private Date dateDeclarationIncident;
	private Boolean flag=false;
	private List typePb;
	private String valueMachine = "";
	private String valueContrat = "";
	private String commentaire = "";
	private Integer idContrat;
	private boolean voirpanel = false;
	private String value;
	

	public String getValueMachine() {
		return valueMachine;
	}


	public void setValueMachine(String valueMachine) {
		this.valueMachine = valueMachine;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	
	public List getTypePb() {
		typePb = new ArrayList();
		IDonneesIncidentDTO donneesIncident = DTOFactory.getIDonneesIncidentDTO();
		List<String> liste = donneesIncident.getListtypePb();
		for(String s : liste){
			typePb.add(new SelectItem(s));
		}
		return typePb;
	}
	
	public void setTypePb(List typePb) {
		this.typePb = typePb;
	}
	
	public Integer getNumMachine() {
		return numMachine;
	}

	public void setNumMachine(Integer numMachine) {
		this.numMachine = numMachine;
	}
	
	private void recuperationNumeroMachine(Integer numeroContrat){
		listMachine = new ArrayList(); 
		IDonneesContratDTO donneesContrat = DTOFactory.getIDonneesContratDTO();
		System.out.println(numeroContrat);
		List<Integer> retour = donneesContrat.getListeMachineByContrat(numeroContrat);
		for(Integer i : retour){
			listMachine.add(new SelectItem(i)); 
		}
	}
	private boolean test = true;
	public void valueChangeListener(ValueChangeEvent event){  
		idContrat = Integer.parseInt(event.getNewValue().toString());
		recuperationNumeroMachine(idContrat);
		test = false;
	}  

	public List getListMachine() {
		return listMachine;
	}

	public void setListMachine(List listMachine) {
		this.listMachine = listMachine;
	}
	
	public List getNumContrat() {
		
	  	numContrat = new ArrayList();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		SessionDTO session = (SessionDTO) httpSession.getAttribute("session");

		IDonneesIncidentDTO donneesIncident = DTOFactory.getIDonneesIncidentDTO();
		ListeContratDTO listeContrat = donneesIncident.getContratsByNumClient(session.getNumeroClient());
		List<Integer> retour = listeContrat.getListeContrat();
		int cpt=0;
		for(Integer i : retour){
			if(cpt==0 && test){cpt++;recuperationNumeroMachine(i);}
			numContrat.add(new SelectItem(i.toString()));
		}
		//recuperationNumeroMachine(idContrat);
		
		return numContrat;
	}

	public void setNumContrat(List numContrat) {
		this.numContrat = numContrat;
	}

	public Date getDateConstatIncident() {
		return dateConstatIncident;
	}

	public void setDateConstatIncident(Date dateConstatIncident) {
		this.dateConstatIncident = dateConstatIncident;
	}

	public Date getDateDeclarationIncident() {
		dateDeclarationIncident = new Date();
		return dateDeclarationIncident;
	}

	public void setDateDeclarationIncident(Date dateDeclarationIncident) {
		this.dateDeclarationIncident = dateDeclarationIncident;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
	public String getValueContrat() {
		return valueContrat;
	}

	public void setValueContrat(String valueContrat) {
		this.valueContrat = valueContrat;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public void confirmation(){
		voirpanel = true;
	}


	public Integer getIdContrat() {
		return idContrat;
	}


	public void setIdContrat(Integer idContrat) {
		this.idContrat = idContrat;
	}


	public boolean isVoirpanel() {
		return voirpanel;
	}


	public void setVoirpanel(boolean voirpanel) {
		this.voirpanel = voirpanel;
	}

	public Integer searchNumTypePb(String value){
		Integer i = 0;
		if(value.equals("Non installée")){
			i = 1;
		}
		if(value.equals("dysfonctionnement")){
			i = 2;
		}
		if(value.equals("panne électrique")){
			i = 3;
		}
		if(value.equals("problème monnayeur")){
			i = 4;
		}
		if(value.equals("problème câblerie")){
			i = 5;
		}
		if(value.equals("machine fracturée")){
			i = 6;
		}
		if(value.equals("vol de produits")){
			i = 7;
		}
		return i;
	}
	
	public String declare(){
		System.out.println("Entrer");
		IDonneesIncidentDTO donneesIncident = DTOFactory.getIDonneesIncidentDTO();
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
	
		HttpSession httpSession = request.getSession(false);
		
		SessionDTO session = (SessionDTO)httpSession.getAttribute("session");
		ContratDTO contrat = new ContratDTO();
		IncidentDTO incident = new IncidentDTO();
		incident.setDateConstatIncident(getDateConstatIncident());
		incident.setDateDeclarationIncident(new Date());
		incident.setFlag(flag);
		incident.setNumTypePb(searchNumTypePb(value));
		incident.setNumClient(session.getNumeroClient());
		incident.setNumContrat(idContrat);
		
		int res = donneesIncident.insertIncident(incident);

		if(res != -1){
			return "ok";
		}
		else
		return "Failure";
	}
	
}
