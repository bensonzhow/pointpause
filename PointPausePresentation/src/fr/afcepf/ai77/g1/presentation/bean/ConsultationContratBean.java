package fr.afcepf.ai77.g1.presentation.bean;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesContratDTO;

public class ConsultationContratBean {
 private List<ContratDTO> listeContratsByClient;
 IDonneesContratDTO donneesContrat = DTOFactory.getIDonneesContratDTO();	
	
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		
	HttpSession httpSession = request.getSession(false);
	SessionDTO session = (SessionDTO) httpSession.getAttribute("session");	
	
 public ConsultationContratBean(){
	 if(session!=null)
	 listeContratsByClient= donneesContrat.getContratById(session.getNumeroClient()); 
 }
 
 public void setListeContratsByClient(List<ContratDTO> listeContratsByClient) {
	this.listeContratsByClient = listeContratsByClient;
}


public List<ContratDTO> getListeContratsByClient() {
	return listeContratsByClient;
}
 
}
