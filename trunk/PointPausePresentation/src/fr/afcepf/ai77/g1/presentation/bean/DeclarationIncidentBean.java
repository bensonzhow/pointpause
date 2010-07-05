package fr.afcepf.ai77.g1.presentation.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.IncidentDTO;
import fr.afcepf.ai77.g1.metiers.dto.ListeContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.ListeMachineDTO;
import fr.afcepf.ai77.g1.metiers.dto.ListeMachinesDTO;
import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.implementations.DonneesIncidentDTOImpl;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesContratDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesIncidentDTO;
import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.TypePb;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;

public class DeclarationIncidentBean {
	
	private Integer numMachine;
	private List numContrat;
	private List listMachine = new ArrayList();
	private Date dateConstatIncident;
	private Date dateDeclarationIncident;
	private Boolean flag=false;
	private List typePb;
	private String valueMachine = "";
	private String valueContrat = "";
	private String commentaire = "";

	
	public List getTypePb() {
		
		typePb = new ArrayList();
		typePb.add(new SelectItem("Aucun"));
		typePb.add(new SelectItem("dysfonctionnement"));
		typePb.add(new SelectItem("panne"));
		return typePb;
	}
	

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


	public void setTypePb(List typePb) {
		this.typePb = typePb;
	}
	
	public Integer getNumMachine() {
		return numMachine;
	}

	public void setNumMachine(Integer numMachine) {
		this.numMachine = numMachine;
	}
	
	public void valueChangeListener(ValueChangeEvent event){  
		System.out.println("Entré");
		
		HtmlSelectOneMenu monComponent = (HtmlSelectOneMenu) FacesContext
		.getCurrentInstance().getViewRoot().findComponent(
				"listeContrat");
		
		System.out.println(monComponent.getLocalValue());
		listMachine = new ArrayList();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		System.out.println("donneesContrat");
		IDonneesContratDTO donneesContrat = DTOFactory.getIDonneesContratDTO();
		System.out.println(valueContrat);
		List<Integer> retour = donneesContrat.getListeMachineByContrat(Integer.parseInt(valueContrat));
		System.out.println("retour");
		for(Integer i : retour){
			System.out.println(i);
		}
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
		for(Integer i : retour){
			numContrat.add(new SelectItem(i.toString()));
		}
		
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
		return valueMachine;
	}

	public void setValue(String value) {
		this.valueMachine = value;
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
		incident.setNumTypePb(2);
		incident.setNumClient(session.getNumeroClient());
		//incident.setNumContrat(contrat.)
		
		int res = donneesIncident.insertIncident(incident);
		
		if(res != -1)
			return "ok";
		else
		return "Failure";
	}
	
}
