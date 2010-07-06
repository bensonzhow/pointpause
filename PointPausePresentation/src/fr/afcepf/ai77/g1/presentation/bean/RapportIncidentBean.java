package fr.afcepf.ai77.g1.presentation.bean;

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

public class RapportIncidentBean {

	private Integer numeroClient;
	private List<IncidentDTO> listeIncidents = null;
	private List<IncidentDTO> hiddenListIncident = null;
	private List<IncidentDTO> completeListIncident = null;
	private List<IncidentStat> listeIncidentStat = new Vector<IncidentStat>();


	

	public List<IncidentStat> getListeIncidentStat() {
		return listeIncidentStat;
	}

	public void setListeIncidentStat(List<IncidentStat> listeIncidentStat) {
		this.listeIncidentStat = listeIncidentStat;
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

		//initialiser les infos de la page
		initInfos();
		
		// par défaut on affiche la liste complete
		setCompleteList();

	}

	
	private void initInfos(){
		//faire la liste cachée d'abord
		computeHiddenList();
		
		//calculer les stats;
		for (IncidentDTO incident : completeListIncident){
			try{
				StatutIncidentDTO statut = incident.getHistorique().get(
						incident.getHistorique().size() - 1);
				
				//si l'incident n'est pas de statut terminé, on doit 
				//rajouter le type de probleme.
				if (statut.getIntStatut()!=3){
					
					//rechercher si la stat existe déjà
					IncidentStat stat = null;
					for (IncidentStat incStat : listeIncidentStat){
						if (incStat.isMe(incident.getNumTypePb())) {stat=incStat;break;}
					}
					
					//si elle existe déjà on a juste à l'incrémenter, sinon on crée un nouveau
					if (stat!=null){
						stat.setCombien(stat.getCombien()+1);
					}
					else{
						stat=new IncidentStat(1,incident.getNumTypePb(),incident.getLibelTypePb());
						listeIncidentStat.add(stat);
					}
					
				}
								
			}catch(Exception e){
				//ignore
			}
		}
		
	}
	

	private void setCompleteList() {
		setListeIncidents(completeListIncident);
	}
	
	private void setHiddentList(){
		setListeIncidents(hiddenListIncident);
	}

	private void computeHiddenList() {
		

		for (IncidentDTO incident : completeListIncident) {

			try {
				StatutIncidentDTO statut = incident.getHistorique().get(
						incident.getHistorique().size() - 1);
				if (statut.getIntStatut()!=3)
					hiddenListIncident.add(incident);
			} catch (Exception e) {
				// ignore;
			}

		}

	}
	
	
	public class IncidentStat{
		Integer combien;
		Integer codeProbleme;
		String libelleProbleme;
		
		
		public Integer getCombien() {
			return combien;
		}

		public void setCombien(Integer combien) {
			this.combien = combien;
		}

		public Integer getCodeProbleme() {
			return codeProbleme;
		}

		public void setCodeProbleme(Integer codeProbleme) {
			this.codeProbleme = codeProbleme;
		}

		public String getLibelleProbleme() {
			return libelleProbleme;
		}

		public void setLibelleProbleme(String libelleProbleme) {
			this.libelleProbleme = libelleProbleme;
		}

		public IncidentStat(){
			combien=0;
		}


		public IncidentStat(Integer combien, Integer codeProbleme,
				String libelleProbleme) {
			super();
			this.combien = combien;
			this.codeProbleme = codeProbleme;
			this.libelleProbleme = libelleProbleme;
		}

		public boolean isMe(Integer codeProbleme){
			return (this.codeProbleme==codeProbleme);
		}

	}

}
