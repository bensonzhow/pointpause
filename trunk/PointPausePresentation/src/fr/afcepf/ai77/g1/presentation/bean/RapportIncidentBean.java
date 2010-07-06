package fr.afcepf.ai77.g1.presentation.bean;

import java.awt.BufferCapabilities.FlipContents;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.faces.context.FacesContext;
import javax.faces.convert.DateTimeConverter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.IncidentDTO;
import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.dto.StatutIncidentDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesIncidentDTO;
import fr.afcepf.ai77.g1.persistence.entity.Incident;
import fr.afcepf.ai77.g1.presentation.beanutils.StatIncidentUtils;
import fr.afcepf.ai77.g1.presentation.beanutils.StatutIncidentStat;
import fr.afcepf.ai77.g1.presentation.beanutils.TypeIncidentStat;

public class RapportIncidentBean {

	private Integer numeroClient;
	private List<IncidentDTO> listeIncidents = null;
	private List<IncidentDTO> hiddenListIncident = new Vector<IncidentDTO>();
	private List<IncidentDTO> completeListIncident = new Vector<IncidentDTO>();

	private List<TypeIncidentStat> listeStatTypeIncidents = null;
	private List<StatutIncidentStat> listeStatStatutIncident = null;

	private boolean displayAll = false;

	public boolean isDisplayAll() {
		return displayAll;
	}

	public void setDisplayAll(boolean displayAll) {
		this.displayAll = displayAll;
	}

	public List<TypeIncidentStat> getListeStatTypeIncidents() {
		return listeStatTypeIncidents;
	}

	public void setListeStatTypeIncidents(
			List<TypeIncidentStat> listeStatTypeIncidents) {
		this.listeStatTypeIncidents = listeStatTypeIncidents;
	}

	public List<StatutIncidentStat> getListeStatStatutIncident() {
		return listeStatStatutIncident;
	}

	public void setListeStatStatutIncident(
			List<StatutIncidentStat> listeStatStatutIncident) {
		this.listeStatStatutIncident = listeStatStatutIncident;
	}

	public Integer getNumeroClient() {
		return numeroClient;
	}

	public List<IncidentDTO> getHiddenListIncident() {
		return hiddenListIncident;
	}

	public void setHiddenListIncident(List<IncidentDTO> hiddenListIncident) {
		this.hiddenListIncident = hiddenListIncident;
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

	public List<IncidentDTO> getCompleteListIncident() {
		return completeListIncident;
	}

	public void setCompleteListIncident(List<IncidentDTO> completeListIncident) {
		this.completeListIncident = completeListIncident;
	}

	public RapportIncidentBean() {

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		SessionDTO session = (SessionDTO) httpSession.getAttribute("session");

		if (session == null)
			return;

		int numClient = session.getNumeroClient();
		IDonneesIncidentDTO donneesIncident = DTOFactory
				.getIDonneesIncidentDTO();

		completeListIncident = donneesIncident
				.getHistoriqueIncidentByClient(numClient);

		// initialiser les infos de la page
		initInfos();

		// par défaut on affiche la liste complete
		setHiddentList();

	}

	private void initInfos() {
		// faire la liste cachée d'abord
		computeHiddenList();

		listeStatStatutIncident = StatIncidentUtils
				.getStatsStatutIncident(completeListIncident);
		listeStatTypeIncidents = StatIncidentUtils
				.getStatsTypeIncident(completeListIncident);

	}

	private void setCompleteList() {
		setListeIncidents(completeListIncident);
	}

	private void setHiddentList() {
		setListeIncidents(hiddenListIncident);
	}

	private void computeHiddenList() {

		for (IncidentDTO incident : completeListIncident) {

			try {
				StatutIncidentDTO statut = incident.getLastStatutDTO();
				if (statut.getIntStatut() != 3)
					hiddenListIncident.add(incident);
			} catch (Exception e) {
				// ignore;
			}

		}

	}

	public void switchView() {
		if (displayAll) {
			setListeIncidents(completeListIncident);
		} else {
			setListeIncidents(hiddenListIncident);
		}
	}
	
	public void setFlagForIncident(){
		    
		 FacesContext context = FacesContext.getCurrentInstance();  
		 String value = context.getExternalContext().getRequestParameterValuesMap().get("nincident")[0];	
		 int nincident= Integer.parseInt(value);
		 
		 
		 //changer le flag dans la DB
		 IDonneesIncidentDTO donneesIncident= DTOFactory.getIDonneesIncidentDTO();
		 donneesIncident.switchIncidentFlag(nincident);
		 
		 //changer le flag dans l'objet listé
		 for (IncidentDTO incident : completeListIncident){
			 if (incident.getNumero()==nincident){
				 incident.setFlag(! incident.getFlag());
				 break;
			 }
		 }
	}

}
