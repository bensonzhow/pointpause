package fr.afcepf.ai77.g1.presentation.bean;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
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
	private List<ContratDTO> getLastContrats;
	private DataModel dataModel = new ListDataModel();
	
	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	
	
	

	/**
	 * @param getLastContrats the getLastContrats to set
	 */
	public void setGetLastContrats(List<ContratDTO> getLastContrats) {
		this.getLastContrats = getLastContrats;
	}

	/**
	 * @return the getLastContrats
	 */
	public List<ContratDTO> getGetLastContrats() {
		return getLastContrats;
	}

	public TableauBordBean(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		SessionDTO session = (SessionDTO) httpSession.getAttribute("session");		
		if(session==null)
			return;
		setNomClient(session.getNom());
		
		//charger la liste des contrats
		IDonneesContratDTO donneesContrat = DTOFactory.getIDonneesContratDTO();	
		setGetLastContrats(donneesContrat.getLastContratPourTableau(session.getNumeroClient()));

		dataModel.setWrappedData(getLastContrats);
		
	}
	
	public DataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	public void switchFlag(){
		System.out.println("on passe dans switch");
		ContratDTO contrat = (ContratDTO) dataModel.getRowData();
		System.out.println(contrat.getNumero());
	}
	
}
