package fr.afcepf.ai77.g1.presentation.bean;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.DataModelEvent;
import javax.faces.model.DataModelListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.richfaces.model.impl.ListDataModel;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesContratDTO;
import fr.afcepf.ai77.g1.persistence.entity.Contrat;

public class TableauBordBean {

	private String nomClient;
	public String test;
	private Boolean flagDeflag;
	private Boolean flagRendered;

	private List<ContratDTO> lastContrats;
	private int idRowSelected;

	IDonneesContratDTO donneesContrat = DTOFactory.getIDonneesContratDTO();	
	
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		
	HttpSession httpSession = request.getSession(false);
	SessionDTO session = (SessionDTO) httpSession.getAttribute("session");	
	/**
	 * @param lastContrats the lastContrats to set
	 */
	public void setLastContrats(List<ContratDTO> lastContrats) {
		this.lastContrats = lastContrats;
	}

	/**
	 * @return the lastContrats
	 */
	public List<ContratDTO> getLastContrats() {
		return lastContrats;
	}

	public TableauBordBean(){
		System.out.println("passage dans le constructeur");
		if(session==null)
			return;
		setNomClient(session.getNom());
		
		//charger la liste des contrats
		
		setLastContrats(donneesContrat.getLastContratPourTableau(session.getNumeroClient()));
		for (ContratDTO contrat : lastContrats) {
			System.out.println(contrat.getNumero());
			System.out.println(contrat.getFlag());
		}
	
	}

	public void switchFlag(){
		System.out.println("on passe dans switch");
		System.out.println(idRowSelected);
	test= "oui";
		ContratDTO cdto = donneesContrat.getContratById(idRowSelected);
		if (cdto.getFlag())
		{cdto.setFlag(false);
		flagRendered=false;}
		else
		{	cdto.setFlag(true);
		flagRendered=true;}
	   donneesContrat.updateContrat(cdto);
	  setLastContrats(donneesContrat.getLastContratPourTableau(session.getNumeroClient()));
		
	}

	/**
	 * @param idRowSelected the idRowSelected to set
	 */
	public void setIdRowSelected(int idRowSelected) {
		this.idRowSelected = idRowSelected;
	}

	/**
	 * @return the idRowSelected
	 */
	public int getIdRowSelected() {
		return idRowSelected;
	}
	public Boolean getFlagDeflag() {
		return flagDeflag;
	}

	public void setFlagDeflag(Boolean flagDeflag) {
		this.flagDeflag = flagDeflag;
	}

	/**
	 * @param flagRendered the flagRendered to set
	 */
	public void setFlagRendered(Boolean flagRendered) {
		this.flagRendered = flagRendered;
	}

	/**
	 * @return the flagRendered
	 */
	public Boolean getFlagRendered() {
		return flagRendered;
	}
	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	/**
	 * @param flagNone the flagNone to set
	 */
	
}
