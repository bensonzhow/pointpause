package fr.afcepf.ai77.g1.presentation.bean;

import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.convert.DateTimeConverter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.IncidentDTO;
import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesIncidentDTO;

public class RapportIncidentBean {

	private Integer numeroClient;
	private List<IncidentDTO> listeIncidents = null;
	
	public Integer getNumeroClient() {
		return numeroClient;
	}
	public void setNumeroClient(Integer numeroClient) {
		this.numeroClient = numeroClient;
	}
	public List<IncidentDTO> getListeIncidents() {
		return listeIncidents;
	}
	public void setListeIncidents(List<IncidentDTO> listeIncidents) {
		this.listeIncidents = listeIncidents;
	}
	 
	
	public RapportIncidentBean(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		SessionDTO session = (SessionDTO) httpSession.getAttribute("session");
		
		if (session ==null) return;
		
		int numClient=session.getNumeroClient();
		IDonneesIncidentDTO donneesIncident = DTOFactory.getIDonneesIncidentDTO();
		
		listeIncidents = donneesIncident.getHistoriqueIncidentByClient(numClient);
		
	
		
	}
	
	

	
}
