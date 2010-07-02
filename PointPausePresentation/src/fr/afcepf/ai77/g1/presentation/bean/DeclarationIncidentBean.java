package fr.afcepf.ai77.g1.presentation.bean;

import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class DeclarationIncidentBean {
	
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
	.getExternalContext().getRequest();
	
	
	
	private Date dateConstatIncident;
	private Date dateDeclarationIncident;
	private String telephone;
	
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String declare(){
		
		return null;
	}
}
