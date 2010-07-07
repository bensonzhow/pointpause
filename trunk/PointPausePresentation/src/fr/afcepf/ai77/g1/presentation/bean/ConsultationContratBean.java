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
	private int idRowSelected;
	
 public ConsultationContratBean(){
	 if(session!=null)
	 listeContratsByClient= donneesContrat.getAllContratsBouquetInstallByClient(session.getNumeroClient());
//	 for (ContratDTO contrat : listeContratsByClient) {
//		contrat.getListeBouquets();
//	}
 }
 
 public void switchFlag(){
		System.out.println("on passe dans switch");
		System.out.println(idRowSelected);
	
	System.out.println("avant getContratById");	
		ContratDTO cdto = donneesContrat.getContratBouquetById(idRowSelected);
		System.out.println("après getContratById");
		if (cdto.getFlag())
		{cdto.setFlag(false);	
		}
		else
		{	cdto.setFlag(true);
		}
	   donneesContrat.updateContrat(cdto);
	   System.out.println("l'update contrat passe");
	   listeContratsByClient= donneesContrat.getAllContratsBouquetInstallByClient(session.getNumeroClient());
		
	}
 
 public void setListeContratsByClient(List<ContratDTO> listeContratsByClient) {
	this.listeContratsByClient = listeContratsByClient;
}


public int getIdRowSelected() {
	return idRowSelected;
}

public void setIdRowSelected(int idRowSelected) {
	this.idRowSelected = idRowSelected;
}

public List<ContratDTO> getListeContratsByClient() {
	return listeContratsByClient;
}
 
}
