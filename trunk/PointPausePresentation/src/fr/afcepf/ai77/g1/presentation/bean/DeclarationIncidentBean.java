package fr.afcepf.ai77.g1.presentation.bean;

import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	private Date dateConstatIncident;
	private Date dateDeclarationIncident;
	private Boolean flag;
	
	
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

	public Date getDateConstatIncident() {
		return dateConstatIncident;
	}

	public void setDateConstatIncident(Date dateConstatIncident) {
		this.dateConstatIncident = dateConstatIncident;
	}

	public Date getDateDeclarationIncident() {
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



	public String declare(){
		IDonneesIncidentDTO donneesIncdent = new DonneesIncidentDTOImpl();
		
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
	
		HttpSession httpSession = request.getSession(false);
		
		
		SessionDTO session = (SessionDTO)httpSession.getAttribute("session");
		ContratDTO contrat = new ContratDTO();
		
		IncidentDTO incident = new IncidentDTO();
		incident.setDateConstatIncident(dateConstatIncident);
		incident.setDateDeclarationIncident(new Date());
		incident.setFlag(flag);
		incident.setNumClient(session.getNumeroClient());
		//incident.setNumContrat(contrat.)
		
		int res = donneesIncdent.insertIncident(incident);
		
		if(res != -1)
			return "ok";
		else
		return "Failure";
	}
}
