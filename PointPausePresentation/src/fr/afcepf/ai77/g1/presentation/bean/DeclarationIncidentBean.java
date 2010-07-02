package fr.afcepf.ai77.g1.presentation.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.IncidentDTO;
import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.implementations.DonneesIncidentDTOImpl;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesIncidentDTO;
import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Contrat;

public class DeclarationIncidentBean {
	
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
	.getExternalContext().getRequest();
	
	
	private Integer numMachine;
	private Integer numContrat;
	private String dateConstatIncident;
	private String dateDeclarationIncident;
	private Boolean flag=false;
	
	
	public Integer getNumMachine() {
		return numMachine;
	}

	public void setNumMachine(Integer numMachine) {
		this.numMachine = numMachine;
	}

	public Integer getNumContrat() {
		return numContrat;
	}

	public void setNumContrat(Integer numContrat) {
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



	public String declare(){
		System.out.println("Entrer");
		IDonneesIncidentDTO donneesIncident = DTOFactory.getIDonneesIncidentDTO();
		
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
	
		HttpSession httpSession = request.getSession(false);
		
		
		SessionDTO session = (SessionDTO)httpSession.getAttribute("session");
		ContratDTO contrat = new ContratDTO();
		System.out.println("Contrat");
		IncidentDTO incident = new IncidentDTO();
		System.out.println("Incident");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Date");
		Date date =null;
		try {
			dateConstatIncident = getDateConstatIncident();
			date = sdf.parse(dateConstatIncident);
			System.out.println("fintry");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		incident.setDateConstatIncident(date);
		System.out.println("ConstatOk");
		incident.setDateDeclarationIncident(new Date());
		System.out.println("Date");
		incident.setFlag(flag);
		System.out.println("Flag");
		incident.setNumTypePb(2);
		incident.setNumClient(session.getNumeroClient());
		System.out.println("NumClient");
		//incident.setNumContrat(contrat.)
		
		int res = donneesIncident.insertIncident(incident);
		System.out.println(res);
		
		if(res != -1)
			return "ok";
		else
		return "Failure";
	}
}
