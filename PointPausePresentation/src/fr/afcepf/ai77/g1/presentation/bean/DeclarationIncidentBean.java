package fr.afcepf.ai77.g1.presentation.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.IncidentDTO;
import fr.afcepf.ai77.g1.metiers.dto.ListeContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.implementations.DonneesIncidentDTOImpl;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesIncidentDTO;
import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.TypePb;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;

public class DeclarationIncidentBean {
	
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
	.getExternalContext().getRequest();
	
	
	private Integer numMachine;
	private List numContrat;
	private String dateConstatIncident;
	private String dateDeclarationIncident;
	private Boolean flag=false;
	private List typePb;
	private String value = "";
	private String valueContrat = "";


	public Integer getNumMachine() {
		return numMachine;
	}

	public List getTypePb() {
		
		typePb = new ArrayList();
		typePb.add(new SelectItem("Aucun"));
		typePb.add(new SelectItem("dysfonctionnement"));
		typePb.add(new SelectItem("panne"));
		 
		return typePb;
	}
	

	public void setTypePb(List typePb) {
		this.typePb = typePb;
	}

	public void setNumMachine(Integer numMachine) {
		this.numMachine = numMachine;
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
//		numContrat = new ArrayList();
//		numContrat.add(new SelectItem("est"));
//		numContrat.add(new SelectItem("est"));
//		numContrat.add(new SelectItem("est"));
//		return numContrat;
		
	}

	public void setNumContrat(List numContrat) {
		this.numContrat = numContrat;
	}

	public String getDateConstatIncident() {
		return dateConstatIncident;
	}

	public void setDateConstatIncident(String dateConstatIncident) {
		this.dateConstatIncident = dateConstatIncident;
	}

	public String getDateDeclarationIncident() {
		return dateDeclarationIncident;
	}

	public void setDateDeclarationIncident(String dateDeclarationIncident) {
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date =null;
		try {
			dateConstatIncident = getDateConstatIncident();
			date = sdf.parse(dateConstatIncident);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		incident.setDateConstatIncident(date);
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
