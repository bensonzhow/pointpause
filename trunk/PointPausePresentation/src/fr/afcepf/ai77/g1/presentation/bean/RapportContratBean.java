package fr.afcepf.ai77.g1.presentation.bean;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesContratDTO;

public class RapportContratBean {
	private List<ContratDTO> listeContrats;


	public List<ContratDTO> getListeContrats() {
		return listeContrats;
	}

	public void setListeContrats(List<ContratDTO> listeContrats) {
		this.listeContrats = listeContrats;
	}
	 
	public RapportContratBean(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		SessionDTO session = (SessionDTO) httpSession.getAttribute("session");
		
		if (session ==null) return;
		
		IDonneesContratDTO donneesContrat = DTOFactory.getIDonneesContratDTO();
		
		List<ContratDTO> liste = donneesContrat.getSyntheseContratbyClient(session.getNumeroClient());
		
		setListeContrats(liste);
	
	}
	
	
	
}
